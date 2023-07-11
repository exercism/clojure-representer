(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (def numbers (count (str num)))

  (->> (str num)
       (map #(Character/digit % 10))
       (map #(exp % numbers))
       (map bigint)
       (reduce +)
       (= num)
       ))