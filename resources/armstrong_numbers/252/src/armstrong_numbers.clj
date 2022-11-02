(ns armstrong-numbers)

(defn digits [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10))
    []))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def d (digits num))
  (def l (count d))
  (= (reduce + (map #(exp % l) d)) num)
)
