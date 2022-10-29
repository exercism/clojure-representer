(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [num]
  (->> (str num)
        seq
        (map str)
        (map read-string))
)

(defn number-of-digits [num]
  (count (str num))
)

(defn armstrong? [num]
  (def num-digits (number-of-digits num))
  (def sum (reduce + (map #(exp % num-digits) (digits num))))
  (= num sum)
)
