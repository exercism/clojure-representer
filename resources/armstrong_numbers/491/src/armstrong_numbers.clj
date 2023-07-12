(ns armstrong-numbers)

(defn exp [x n] (loop [acc 1 n n] (if (zero? n) acc (recur (* x acc) (dec n)))))

(defn armstrong?
  [num]
  (let [size (count (str num))
        digits (map #(Character/digit % 10) (seq (str num)))
        exponents (map #(exp %1 size) digits)]
    (= (reduce + exponents) num)))
