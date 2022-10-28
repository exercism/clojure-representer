(ns clojure-representer.main
  (:require [clojure-representer.analyzer.jvm :as ana.jvm]
            [clojure-representer.analyzer.passes.jvm.emit-form :as e]
            [clojure-representer.analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]))

(defn remove-path [s]
  (-> s
      z/of-string
      (z/find-value z/next :file)
      z/right
      (z/replace "")
      z/root-string))

(-> 
    (io/file "resources/twofers/0/" "two_fer.clj")
    z/of-file
    z/up
    z/sexpr
    ana.jvm/analyze+eval
    e/emit-hygienic-form
    ;str
    ;z/of-string
    ;z/sexpr
    )

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        _ (reset! placeholder 0)
        _ (reset! mappings {})
        representation (-> in-dir
                           (io/file file)
                           str
                           z/of-file
                           z/up
                           z/sexpr
                           ana.jvm/analyze+eval
                           e/emit-hygienic-form
                           )]
   ; (println "\nMappings:\n")
    (spit (str (io/file out-dir "mapping.json"))
          (json/write-str (into {} (map (fn [[k v]] [v k]) @mappings))))
    (spit (str (io/file out-dir "representation.txt"))
          (with-out-str (pp/pprint representation)))
    ;(println "\nRepresentation:\n")
    ;(pp/pprint representation)
    ))

(comment
  (doseq [n (range 500)]
    (represent {:slug    "two-fer"
                :in-dir  (str "resources/twofers/" n "/")
                :out-dir (str "resources/twofers/" n "/")}))
  )

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))
