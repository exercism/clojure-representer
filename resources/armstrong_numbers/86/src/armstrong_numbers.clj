(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [num_str (str num)
        total_length (count num_str)
        total_sum (reduce + (map (fn [n] (pow (Character/digit n 10) total_length)) num_str))]
    (= num total_sum)))
