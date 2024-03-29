(ns clojure-representer.main
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [babashka.fs :as fs]
            [cheshire.core :as json]
            [clojure.walk :as walk]
            [clojure.set :as set]
            [clojure-representer.symbols :refer [clojure-core-syms]]))

(defn file->code
  "Takes a filename as a string or java.io.File.
   Returns the Clojure forms wrapped in a `do`."
  [f]
  (z/sexpr (z/of-file* (str f))))

(defn symbols [form]
  (let [syms (atom [])]
    (walk/prewalk
     (fn [x] (when (= clojure.lang.Symbol (type x))
               (swap! syms conj x)) x) 
     (walk/macroexpand-all form))
    (set @syms)))

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

(def mappings (atom nil))

(defn replace-symbols [slug in-dir]
  (let [src (walk/macroexpand-all (file->code (fs/file in-dir "src" (str (str/replace slug "-" "_") ".clj"))))
        locals (locals src slug in-dir)
        placeholders (placeholders locals)]
    (reset! mappings (into {} (map (fn [[k v]] [v k]) placeholders)))
    (walk/prewalk (fn [x] (if (contains? locals x) (placeholders x) x)) src)))

(defn clean
  "Macroexpansion of destructuring bindings result in objects like this:
   #object[clojure.core$nth 0x94442d9 \"clojure.core$nth@94442d9\"].
   This normalizes them."
  [s]
  (-> s
      (str/replace #"nth@?\s?\w*" "nth")
      (str/replace #"seq_+\w+_*@?\w+\s?\w*" "seq")
      (str/replace #"first_+\w+\s?@?\w*" "first")
      (str/replace #"next_+\w+\s?@?\w*" "next")))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [representation (clean (str (list (replace-symbols slug in-dir))))]
    (spit (str (io/file out-dir "mapping.json")) 
          (json/generate-string @mappings {:pretty true}))
    ;; uncomment to update expected representations
    ;(spit (str (io/file out-dir "expected-representation.txt")) representation)
    (spit (str (io/file out-dir "representation.txt")) representation)
    (spit (str (io/file out-dir "representation.json"))
          (json/generate-string {:version 2} {:pretty true}))))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug
              :in-dir in-dir
              :out-dir out-dir}))
