(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
(let
    [digits     (map #(Character/getNumericValue %) (str num))
     count      (count digits)
     power-digits (map #(apply * (repeat count %)) digits)]
    (= num (apply + power-digits))))