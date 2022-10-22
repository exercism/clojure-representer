(ns clojure-representer
  (:require [analyzer.jvm :as ana.jvm]
            [analyzer.passes.jvm.emit-form :as e]
            [analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [cheshire.core :as json]
            [clojure.pprint :as pp])
  (:gen-class))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        _ (reset! placeholder 0)
        _ (reset! mappings {})
        representation (e/emit-hygienic-form (ana.jvm/analyze (z/sexpr (z/of-file (str (io/file in-dir file))))))]
    (spit (str (io/file out-dir "mapping.json"))
          (json/generate-string (into {} (map (fn [[k v]] [v k]) @mappings))
                                {:pretty true}))
    (spit (str (io/file out-dir "representation.txt"))
          (with-out-str (pp/pprint representation)))
    representation))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))

(comment
  (first (represent {:slug "two-fer" :in-dir "resources/twofers/0" :out-dir "resources/"}))
  )