(ns armstrong-numbers)

;; digits of a number
(defn digits [num res]
  (if (< num 10) (conj res num)
    (recur (quot num 10) (conj res (mod num 10)))))

;; exponent: base to the power of n
(defn ** [base n]
  (reduce * (repeat n base)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [ds (digits num [])
        sz (count ds)]
    (= (reduce + (map #(** % sz) ds)) num)))
