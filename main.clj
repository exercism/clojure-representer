(ns main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [babashka.fs :as fs]
            [cheshire.core :as json]
            [clojure.walk :as walk]
            [clojure.set :as set]))

(defn file->code
  "Takes a filename as a string or java.io.File.
   Returns the Clojure forms wrapped in a `do`."
  [f]
  (z/sexpr (z/of-file* (str f))))

;; Destructuring bindings expand to something like:
;; #object[clojure.core$nth 0x75cd3577 "clojure.core$nth@75cd3577"]
;; I can normalize it using a regex.

(defn clean [s]
  (-> s
      (str/replace #"nth\s0x\w+" "nth")
      (str/replace #"nth@\w+" "nth")))

;; we need to expand macros *before* we analyze locals,
;; otherwise there could be unnamed shorthand variables.
;; This way they will be converted to standard anonymous functions.

(defn symbols [form]
  (let [syms (atom [])]
    (walk/prewalk
     (fn [x] (when (= clojure.lang.Symbol (type x))
               (swap! syms conj x)) x) 
     (walk/macroexpand-all form))
    (set @syms)))

(load-file "symbols.clj")

(defn locals [src slug in-dir]
  (let [test (file->code (fs/file in-dir "test" (str (str/replace slug "-" "_") "_test.clj")))]
    (set/difference
     (set (remove 
           #(or (contains? clojure-core-syms %)
                (str/starts-with? (str %) "clojure.")
                (str/starts-with? (str %) "Character/")
                (str/starts-with? (str %) "Integer/")
                (special-symbol? %))
           (symbols src)))
     (symbols test))))

(defn placeholders [locals]
  (let [placeholders (map #(symbol (str "PLACEHOLDER-" %))
                          (range (count locals)))]
    (zipmap locals placeholders)))

(defn replace-symbols [slug in-dir]
  (let [src (walk/macroexpand-all (file->code (fs/file in-dir "src" (str (str/replace slug "-" "_") ".clj"))))
        locals (locals src slug in-dir)
        placeholders (placeholders locals)]
    (walk/prewalk (fn [x] (if (contains? locals x) (placeholders x) x))
                  src)))

(replace-symbols "armstrong-numbers" (str "resources/armstrong_numbers/" 1 "/"))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [representation (-> (str (list (replace-symbols slug in-dir))) z/of-string)]
    (spit (str (io/file out-dir "mapping.json")) (json/generate-string 
           (into {} (map (fn [[k v]] [v k]) @mappings)) {:pretty true}))
    (spit (str (io/file out-dir "representation.txt")) (str representation))
    (spit (str (io/file out-dir "representation.json"))
          (json/generate-string {:version 2} {:pretty true}))))
