(ns armstrong-numbers)

(defn calculate-number [digit-count digit]
  (Math/pow (Integer/parseInt digit) digit-count))

(defn armstrong? [num] ;; <- arglist goes here
  (let [exp (count (str num))
        calc (partial calculate-number exp)]
    (== num (reduce + (map #(calc (str %)) (seq (str num)))))))
