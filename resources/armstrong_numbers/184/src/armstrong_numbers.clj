(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (def result (atom 0))
  ;; your code goes here
  (doseq [n (seq (str num))]
    (reset! result (+ @result (exp (Character/digit n 10) (count (str num))))))
  (= num @result)
)
