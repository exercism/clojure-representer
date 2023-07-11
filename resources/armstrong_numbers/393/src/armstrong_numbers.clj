(ns armstrong-numbers
  (:require 
           [clojure.string :refer [split]]))

(defn armstrong? [num]
  (->> 
    (-> num
      str
      (split #""))
    (map read-string)
    (map #(reduce * (repeat (count (str num)) %)))
    (reduce +)
    (= num)))



