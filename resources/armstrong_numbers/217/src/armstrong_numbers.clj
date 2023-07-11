(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (apply + (map #(exp (Character/digit % 10) (count (str num))) (str num))))
)
