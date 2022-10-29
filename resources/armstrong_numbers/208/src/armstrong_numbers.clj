(ns armstrong-numbers)

(defn numdigits
  [num]
  (count (str num))
)

(defn expt
  [x n]
  (reduce * (repeat n x))
)

(defn armstrong? [num] ;; <- arglist goes here
    (= num (reduce + (map #(expt (read-string (str %)) (numdigits num)) (str num))))
)
