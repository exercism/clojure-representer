(ns armstrong-numbers)

(defn digits [num]
  (if (< num 10)
    [num]
    (conj (digits (quot num 10)) (mod num 10))))


(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digs (digits num)
        n (count digs)
        exp-digs (map #(exp % n) digs)
        sum-of-exp-digs (reduce + exp-digs)]
    (= num sum-of-exp-digs)))
