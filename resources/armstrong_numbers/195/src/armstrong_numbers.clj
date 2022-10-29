(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn parse-digits
  "Accept integer and parse into individual digits"
  [num]
  (map #(- (int %1) 48) (seq (str num))))

(defn armstrong?
  "An Armstrong number is a number that is the sum of its own digits each
  raised to the power of the number of digits. Return boolean to indicate
  whether argument passed is a valid Armstrong number."
  [num]
  (let [pow (count (str num))]
    (= num (reduce + (map #(math/expt %1 pow) (parse-digits num))))))
