(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn pow [num exp]
  (reduce * (repeat exp num)))
(defn armstrong? [num]
  (let [strings (str/split (str num) #"")
        exp (count strings)]
    (= (bigdec num) (reduce +' (map #(pow (bigdec %) exp) strings)))))