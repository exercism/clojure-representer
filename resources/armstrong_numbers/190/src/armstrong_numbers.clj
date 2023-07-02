(ns armstrong-numbers)

(defn get-digits
  [num]
  (for [n (str num)]
    (- (byte n) 48)))

(defn pow
  [x n]
  (reduce * (repeat n x)))


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (get-digits num)
        sum (reduce + (map #(pow % (count digits)) digits))]
    (= num sum)))
