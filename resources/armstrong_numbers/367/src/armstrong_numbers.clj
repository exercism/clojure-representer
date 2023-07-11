(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [
        num-as-string (str num)
        number-of-digits (count num-as-string)
        digits (map #(BigInteger. (str %)) num-as-string)
        armstrong-sum (reduce #(+ %1 (.pow %2 number-of-digits)) 0 digits)
        ]
    (= num (long armstrong-sum))))
