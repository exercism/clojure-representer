(ns armstrong-numbers)


(defn digits [n]
  (if (< n 10)
    [n]
    (conj (digits (quot n 10)) (rem n 10))))

(defn exp [num exp]
  (reduce * (repeat exp num)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def vec-digits (digits num))
  (= num 
     (reduce + (map #(exp % (count vec-digits)) vec-digits)))
)
