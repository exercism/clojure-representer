(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn number-of-digits
  [num]
  (loop [current-num num
         sum 0]
    (if (zero? current-num)
      sum
      (recur (quot current-num 10) (inc sum)))))

(defn number-recur-sum
  [num]
  (loop [current-num num
         digits (number-of-digits num)
         sum 0]
    (if (= current-num 0)
      sum
      (let [rest (quot current-num 10)
            amount-to-sum (long (exp (mod current-num 10) digits))]
        (recur rest digits (+ amount-to-sum sum)))
      )
    )
  )


(defn armstrong? [num]                                      ;; <- arglist goes here
  (== num (number-recur-sum num))
  )
