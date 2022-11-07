
(ns armstrong-numbers)
(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))
(defn armstrong? [num] ;; <- arglist goes here
  (= num (reduce + (map #(exp (Long/parseLong (str %)) (count (str num))) (str num))))
)
