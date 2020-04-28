(ns exercism.clojure-representer
  (:require [clojure.java.shell :as shell]
            [clojure.edn :as edn]))

(defn represent [n]
  (edn/read-string
   (:out 
    (shell/sh "clj-kondo"
              "--lint"
              (str "resources/twofers/" n "/two_fer.clj")
              "--config" "{:output {:analysis true :format :edn}}"))))

(defn -main
  "Grabs a twofer by number."
  [n]
  (slurp (str "resources/twofers/" n "/two_fer.clj")))

(comment
  (represent 0)
  )