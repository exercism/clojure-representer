
(ns armstrong-numbers)
(defn expt [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))
(defn armstrong? [num] ;; <- arglist goes here
  (= num (reduce + (map #(expt (Long/parseLong (str %)) (count (str num))) (str num))))
)
