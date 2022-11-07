(ns armstrong-numbers)

(defn get-vector-of-numbers [num]
  (if (pos? num)
    (conj (get-vector-of-numbers (quot num 10)) (mod num 10))
    []))

;; (get-vector-of-numbers 123)

(defn exp [n, x]
  (reduce * (repeat n x)))

;; (exp 3, 2)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def numbers (get-vector-of-numbers num))
  (= num (reduce + (map (partial exp (count numbers)) numbers))))

;; (armstrong? 9)
