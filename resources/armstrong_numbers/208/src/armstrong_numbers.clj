(ns armstrong-numbers)

(defn numdigits
  [num]
  (count (str num))
)

(defn exp
  [x n]
  (reduce * (repeat n x))
)

(defn armstrong? [num] ;; <- arglist goes here
    (= num (reduce + (map #(exp (read-string (str %)) (numdigits num)) (str num))))
)
