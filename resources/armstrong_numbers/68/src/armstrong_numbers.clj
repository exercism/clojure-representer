(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [num-string (seq (str num))]
    (let [len (count num-string)]
      (= num (reduce + (into [] (map #(exp (Character/digit % 10) len) num-string)))))))