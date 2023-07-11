(ns armstrong-numbers)

(defn count-digits [n]
  (loop [x n c 0]
    (cond
      (= x 0) c
      (>= n 0) (recur (quot x 10) (inc c)))))

(defn exp [base pow]
  (apply * (take pow (repeat base))))

(defn sum-digits [n]
  (loop [x n r 0]
    (cond
      (= x 0) r
      (>= n 0) (recur (quot x 10) (+ r (long (exp (mod x 10) (count-digits n))))))))


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (sum-digits num))
)
