(ns armstrong-numbers)

(defn number-to-digits [num]
  (if (< num 10) [num]
      (conj (number-to-digits (quot num 10)) (rem num 10))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (number-to-digits num)
        num-digits (count digits)]
        (== (reduce + (map #(exp % num-digits) digits)) num)))
