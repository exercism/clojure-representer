(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [ln (count (str num))]
    (=
      (reduce #(+' %1 (long (exp (Character/digit %2 10) ln))) 0 (str num))
      (long num))))