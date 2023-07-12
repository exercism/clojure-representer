(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong?
  "Takes a number and determines whehter the sum of its digits raised to the power
  of the count of its digits is equal to itself"
  [num]
  (let [digits (map #(Character/getNumericValue %) (str num)) x (count digits)]
  (= (long (reduce + (map #(math/expt % x) digits))) num))
)
