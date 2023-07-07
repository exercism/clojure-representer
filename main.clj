(ns main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [cheshire.core :as json]
            [clojure.pprint :as pp]
            [clojure.edn :as edn]
            [clojure.java.shell :as shell]))

(defn analyze [f]
  (let [cmd ["./clj-kondo" "--lint" (str f) "--config"
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

(defn walk
  "Traverses form, an arbitrary data structure.  inner and outer are
  functions.  Applies inner to each element of form, building up a
  data structure of the same type, then applies outer to the result.
  Recognizes all Clojure data structures. Consumes seqs as with doall."

  {:added "1.1"}
  [inner outer form]
  (cond
    (list? form) (outer (apply list (map inner form)))
    (instance? clojure.lang.IMapEntry form)
    (outer (clojure.lang.MapEntry/create (inner (key form)) (inner (val form))))
    (seq? form) (outer (doall (map inner form)))
    (instance? clojure.lang.IRecord form)
    (outer (reduce (fn [r x] (conj r (inner x))) form form))
    (coll? form) (outer (into (empty form) (map inner form)))
    :else (outer form)))

(defn prewalk
  "Like postwalk, but does pre-order traversal."
  {:added "1.1"}
  [f form]
  (walk (partial prewalk f) identity (f form)))

(defn macroexpand-all
  "Recursively performs all possible macroexpansions in form."
  {:added "1.1"}
  [form]
  (prewalk (fn [x] (if (seq? x) (macroexpand x) x)) form))

(defn replace-locals [f]
  (let [placeholders (placeholders f)]
    (reset! mappings placeholders)
    (reset! placeholder (count placeholders))
    (prewalk (fn [x] (if (contains? placeholders x) (placeholders x) x))
             (macroexpand-all (z/sexpr (z/of-file* f))))))

(def code (atom nil))

(defn unreplaced-def?
  "Returns non-nil if the code represented by `z`
   contains an unreplaced top-level def."
  [z]
  (z/find-next-depth-first z
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
  (if-not (unreplaced-def? z) z
          (let [var (-> z (z/find-next-depth-first
                           #(and (= 'def (z/sexpr %))
                                 (or (< (count (str (z/sexpr (z/right %)))) 12)
                                     (not= "PLACEHOLDER-"
                                           (subs (str (z/sexpr (z/right %))) 0 12)))))
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
  (if-not (unreplaced-def? z)
    (z/sexpr z)
      (replace-defs (replace-def z))))

(comment
  (z/sexpr (z/of-string* (str/replace 
                          (str
                           (replace-defs
                            (-> (str (list (replace-locals f)))
                                z/of-string)))
                          #"(\w+)__\d+" "$1")))
  
  )

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (io/file in-dir "src" (str (str/replace slug "-" "_") ".clj"))
        representation (z/sexpr (z/of-string* (str/replace (str (replace-defs (-> (str (list (replace-locals file)))
                                                                                  z/of-string)))
                                                           #"(\w+)__\d+" "$1")))]
    (spit (str (io/file out-dir "mapping.json"))
          (json/generate-string (into {} (map (fn [[k v]] [v k]) @mappings))
                                {:pretty true}))
    (spit (str (io/file out-dir "expected-representation.txt"))
          (with-out-str (pp/pprint representation)))
    (spit (str (io/file out-dir "representation.json"))
          (json/generate-string {:version 1} {:pretty true}))))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))

(when *command-line-args*
  (let [[slug in out] *command-line-args*]
    (println slug in out)
    (-main slug in out)))