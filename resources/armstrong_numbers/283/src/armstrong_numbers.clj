(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn num_digits [n]
  (count (str n)))

;; map over all digits in num
;; raise each digit to the power of number of digits
;; sum the result
;; compare to num
(defn armstrong? [num]
  (let [nd (num_digits num)]
    (def x (map #(math/expt % nd) (map #(Character/getNumericValue %) (str num))))
  (= num (reduce + x)))
)
