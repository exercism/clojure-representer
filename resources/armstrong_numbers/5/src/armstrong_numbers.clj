(ns armstrong-numbers)

(defn char->int [c] (- (long c) (long \0)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [str-num (String/valueOf num)
        digits (count str-num)
        sum (reduce #(+' %1 (long (exp (char->int %2) digits))) 0 str-num)]
    (= sum num)))
