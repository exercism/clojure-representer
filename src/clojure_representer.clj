(ns clojure-representer
  (:require [analyzer.jvm :as ana.jvm]
            [analyzer.passes.jvm.emit-form :as e]
            [analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        _ (reset! placeholder 0)
        _ (reset! mappings {})
        representation (e/emit-hygienic-form (ana.jvm/analyze+eval (z/sexpr (z/up (z/of-file (str (io/file in-dir file)))))))]
    (println "\nMappings:\n")
    (spit (str (io/file out-dir "mapping.json"))
          (json/pprint-json (into {} (map (fn [[k v]] [v k]) @mappings))))
    (spit (str (io/file out-dir "representation.txt"))
          (with-out-str (pp/pprint representation)))
    (println "\nRepresentation:\n")
    (pp/pprint representation)))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))
