(ns armstrong-numbers)

(defn pow [base power]
  (reduce * (repeat power base)))

(defn digits
    [x]
    (if (< x 10)
        [x]
        (conj (digits (quot x 10))
              (rem x 10))))


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (digits num)]
    (= num (reduce + (map #(pow % (count nums)) nums)))
))
