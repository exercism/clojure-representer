(ns armstrong-numbers
  (:require [clojure.string :as s]))

(defn armstrong? [num]
  (let [digits (map #(Integer/parseInt (str %)) (seq (str num)))
        len (count digits)
        sum (int (reduce + (map #(Math/pow % len) digits)))]
    (= num sum)))

(comment
  (map #(Integer/parseInt (str %)) (seq (str 123)))
  (armstrong? 153))
