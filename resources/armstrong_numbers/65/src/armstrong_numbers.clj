(ns armstrong-numbers)

(defn- exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (= num (reduce + (map #(exp (Character/digit %1 10) (count (str num))) (seq (str num)))))
)
