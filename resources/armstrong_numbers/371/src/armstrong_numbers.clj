(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (map #(Character/digit % 10) (str num))
        sum (reduce + (map #(exp % (count digits)) digits))]
    (= (long sum) num)))
