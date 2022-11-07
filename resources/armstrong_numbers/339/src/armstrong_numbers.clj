(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [n (str num)
        p (count n)]
    (== num (reduce + (map #(reduce * (repeat p (- (int %) 48))) n))))
)
