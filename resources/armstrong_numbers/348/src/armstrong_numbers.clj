(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (if (= num 0)
    true
    (= num (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(exp (mod % 10) (count(str num))))
       (reduce +)))
    )
)
