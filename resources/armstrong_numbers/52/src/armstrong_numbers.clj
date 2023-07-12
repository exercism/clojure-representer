(ns armstrong-numbers)

(defn as-int-seq [num]
  (map #(Integer/parseInt (str %)) (str num)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong [num] ;; <- arglist goes here
  (let [num-digits (count (str num))
        digits (as-int-seq num)]
    (reduce #(+ %1 (exp %2 num-digits)) (bigint 0) digits)))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong num)))