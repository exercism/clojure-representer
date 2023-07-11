(ns armstrong-numbers)

;; if x < 10, then there is just one digit
;; if x >= 10, then conjoin the remainder of x / 10 recursively
(defn digits [x]
  (cond
    (>= x 10) (conj (digits (quot x 10)) (long (rem x 10)))
    :else [x]))

(defn pow [exp]
  #(reduce * (repeat exp %1)))

(defn armsum [digits]
  (reduce + (map (pow (count digits)) digits)))

(defn armstrong? [num]
  (= (long num) (armsum (digits num))))
