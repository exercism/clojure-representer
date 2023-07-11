(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
(let
    [digits     (map #(Character/getNumericValue %) (str num))
     count      (count digits)
     pow-digits (map #(apply * (repeat count %)) digits)]
    (= num (apply + pow-digits))))