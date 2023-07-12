(ns armstrong-numbers)

(defn digits [n]
  (map #(read-string (str %)) (str n)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] 
  (def ds (digits num))
  (def x (count ds))
  (def anum (reduce + (map #(exp % x) ds)))
  (= num anum)
)
