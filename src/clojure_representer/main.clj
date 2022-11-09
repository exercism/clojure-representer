(ns clojure-representer.main
  (:require [clojure-representer.analyzer.jvm :as ana.jvm]
            [clojure-representer.analyzer.passes.jvm.emit-form :as e]
            [clojure-representer.analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]
            [clojure.pprint :as pprint]))

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
    (spit (str (io/file out-dir "expected-representation.txt"))
          (with-out-str (pp/pprint representation)))))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))

#_(try
  (-> (io/file (str "resources/run-length-encoding/" 148 "/src/") "run_length_encoding.clj")
      normalize
      z/of-string
      z/sexpr)
  (catch Exception e (str "caught exception: " (.getMessage e))))

(spit "unique_run_length_encoding.clj"
      (with-out-str
        (clojure.pprint/pprint
        (set
         (map
          (fn [n] 
            (let [dir (str "resources/run-length-encoding/" n "/src/")
                  file-name "run_length_encoding.clj"]
              (try
                (-> (io/file dir file-name)
                    normalize
                    z/of-string
                    z/sexpr)
                (catch Exception e (str "Exception in" dir file-name (.getMessage e))))))
          (range 500))))))
