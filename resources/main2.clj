(ns main2
  (:require [clojure-representer.analyzer.jvm :as ana.jvm]
            [clojure-representer.analyzer.passes.jvm.emit-form :as e]
            [clojure-representer.analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]))

(defn normalize
  "Takes a Java.io.File containing Clojure code
   and outputs a string representing a normalized, 
   fully macroexpanded version of itself."
  [f]
  (-> (str f)
      z/of-file
      z/up
      z/sexpr
      ana.jvm/analyze+eval
      e/emit-hygienic-form
      str))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        _              (reset! placeholder 0)
        _              (reset! mappings {})
        representation (-> (io/file in-dir file)
                           normalize
                           z/of-string
                           z/sexpr)]
    (spit (str (io/file out-dir "mapping.json"))
          (json/write-str (into {} (map (fn [[k v]] [v k]) @mappings))))
    (spit (str (io/file out-dir "representation.txt"))
          (with-out-str (pp/pprint representation)))))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))
