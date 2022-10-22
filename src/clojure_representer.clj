(ns clojure-representer
  (:require [analyzer.jvm :as ana.jvm]
            [analyzer.passes.jvm.emit-form :as e]
            [analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [cheshire.core :as json]
            [clojure.pprint :as pp]))

#_(defn represent [{:keys [slug in-dir out-dir]}]
  (println (type slug)))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        _              (io/copy (io/file in-dir file)
                                (io/file "src" file))
        _ (reset! placeholder 0)
        _ (reset! mappings {})
        representation (map e/emit-hygienic-form
                            (ana.jvm/analyze-ns slug))]
    (spit (str out-dir "mapping.json")
          (json/generate-string (into {} (map (fn [[k v]] [v k]) @mappings))
                                {:pretty true}))
    (spit (str out-dir "representation.txt")
          (with-out-str (pp/pprint representation)))
    representation))

(comment
  (first (represent {:slug "two-fer" :in-dir "resources/twofers/0" :out-dir "resources/"}))
  )