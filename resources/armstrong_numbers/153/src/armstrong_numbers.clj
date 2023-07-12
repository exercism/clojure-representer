(ns armstrong-numbers
  (:require [clojure.string :as string]))

(defn armstrong? [num]
  (let [num-str (str num)
        num-len (count num-str)
        num-digits (map #(Integer/parseInt %) (string/split num-str #""))
        num-powed (map #(Math/pow % num-len) num-digits)]
    (== num (reduce + num-powed))))
