(ns armstrong-numbers)

(defn count-digits [num count]
  (if (= num 0) count
    (count-digits (quot num 10) (+ count 1))))

(defn square [x]
  (* x x))

(defn compute-exp [base exp]
  (cond
    (= exp 0) 1
    (even? exp) (square (compute-exp base (quot exp 2)))
    :else (* base (compute-exp base (- exp 1)))))

(defn sum-powers-of-digits [num, digits, sum]
  (if (= num 0) sum
    (sum-powers-of-digits 
      (quot num 10) 
      digits 
      (+ sum (compute-exp (mod num 10) digits)))))

(defn armstrong? [num]
  (= num (sum-powers-of-digits num (count-digits num 0) 0))
)