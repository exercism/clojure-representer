(ns armstrong-numbers)

(defn num_seq 
  [num]
  (map #(Integer/parseInt (str %)) (str num)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (num_seq num)
        num-digits (count digits)
        sum-of-powers (reduce + (map #(exp % num-digits) digits))]
    (= num sum-of-powers)))
