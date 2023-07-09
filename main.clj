(ns main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [cheshire.core :as json]
            [clojure.pprint :as pp]
            [clojure.walk :as walk]
            [clojure.edn :as edn]
            [clojure.java.shell :as shell]))

(def f (io/file "resources" "armstrong_numbers"
                "0" "src" "armstrong_numbers.clj"))

(defn file->code
  "Takes a filename as a string or java.io.File.
   Returns the Clojure forms wrapped in a `do`."
  [f]
  (z/sexpr (z/of-file* (str f))))

;; we need to expand macros *before* we analyze locals,
;; otherwise there could be unnamed shorthand variables.
;; This way they will be converted to standard anonymous functions.
(defn expand-macros
  "Takes a filename as a string or java.io.File, and writes
   a file named \"expanded.clj\" containing the recursively 
   macroexpanded Clojure forms wrapped in a `do`."
  [f]
  (spit "expanded.clj"
        (->> f
             file->code
             walk/macroexpand-all
             list
             pp/pprint
             with-out-str)))

(defn analyze [f]
  (let [_ (expand-macros f)
        bin (if (try (shell/sh "ls") (catch Exception e false))
                   "./clj-kondo" "./clj-kondo.exe")
        cmd [bin "--lint" "expanded.clj" "--config"
             "{:output {:format :edn},:analysis {:locals true :arglists true}}"]]
    (:analysis (edn/read-string (:out (apply shell/sh cmd))))))

(defn locals [f]
  (->> (analyze f)
       :locals
       (into (:local-usages (analyze f)))
       (map :name)
       set))

(defn placeholders [f]
  (let [locals (locals f)
        placeholders (map #(symbol (str "PLACEHOLDER-" %)) 
                          (range (count locals)))]
    (zipmap locals placeholders)))

(def mappings (atom {}))
(def placeholder (atom 0)) 

(defn replace-locals [f]
  (let [placeholders (placeholders f)]
    (reset! mappings placeholders)
    (reset! placeholder (count placeholders))
    (walk/prewalk (fn [x] (if (contains? placeholders x) (placeholders x) x))
             (walk/macroexpand-all (z/sexpr (z/of-file* f))))))

(def code (atom nil))

(defn next-unreplaced-def
  "Returns the next unreplaced top-level def by a depth-first walk. 
   If all defs have been replaced, returns nil."
  [z]
  (z/find-next-depth-first 
   z
   #(and (= 'def (z/sexpr %))
         (or (< (count (str (z/sexpr (z/right %)))) 12)
             (not= "PLACEHOLDER-"
                   (subs (str (z/sexpr (z/right %))) 0 12))))))

(defn replace-def
  "Takes a zipper representing normalized code,
   and locates the first top-level var definition
   via a depth-first walk. Replaces all occurances
   of the var name in the code and outputs a new zipper.
   If all var-names have been replaced,
   Outputs the zipper as-is."
  [z]
  (if-not (next-unreplaced-def z) z
          (let [var 
                (-> z
                    next-unreplaced-def
                    z/right
                    z/sexpr)
                z2 
                (z/prewalk z (fn select [zloc]
                               (= var (z/sexpr zloc)))
                           (fn visit [zloc]
                             (z/replace zloc (symbol (str "PLACEHOLDER-" @placeholder)))))]
            
              (reset! code (z/of-string (-> z2 z/root-string)))
              (swap! mappings assoc (str var) (str "PLACEHOLDER-" @placeholder))
              (swap! placeholder inc)
              z2)))

(defn replace-defs [z]
  (if-not (next-unreplaced-def z)
    (z/sexpr z)
      (replace-defs (replace-def z))))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (io/file in-dir "src" (str (str/replace slug "-" "_") ".clj"))
        representation (z/sexpr (z/of-string* (str/replace (str (replace-defs (-> (str (list (replace-locals file)))
                                                                                  z/of-string)))
                                                           #"(\w+)__\d+" "$1")))]
    (spit (str (io/file out-dir "mapping.json"))
          (json/generate-string (into {} (map (fn [[k v]] [v k]) @mappings))
                                {:pretty true}))
    (spit (str (io/file out-dir "representation.txt"))
          (str representation))
    (spit (str (io/file out-dir "representation.json"))
          (json/generate-string {:version 2} {:pretty true}))))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))

(when *command-line-args*
  (let [[slug in out] *command-line-args*]
    (println slug in out)
    (-main slug in out)))
