(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

;; An Armstrong number is a number that is the sum of its own digits each
;; raised to the power of the number of digits.

;; For example:
;; - 9 is an Armstrong number, because `9 = 9^1 = 9`
;; - 10 is *not* an Armstrong number, because `10 != 1^2 + 0^2 = 1`
;; - 153 is an Armstrong number, because: `153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153`
;; - 154 is *not* an Armstrong number, because: `154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190`

;; Hat-tip: https://stackoverflow.com/a/29942388/6732127
(defn digits [n]
  "Return a vector of the individual digits of input number."
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10))
    []))

(defn armstrong? [num]
  "Return true if input number is an Armstrong number, defined as a number that
  is equal to the sum of its own digits each raised to the power of the number
  of digits."
  (let [digits (digits num)
        length (count (str num))]
    ;; Note that the syntax of math/expt is base followed by power
    (= num (apply + (for [x digits] (math/expt x length))))))
