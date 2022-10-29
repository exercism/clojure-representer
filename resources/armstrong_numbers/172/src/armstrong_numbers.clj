(ns armstrong-numbers)

;; my way of doing exponentioation
(defn exp
  ([number power]
   (exp number power 1))
  ([number power sum]
   (if (= power 0)
     sum
     (exp number (- power 1) (* sum number)))))

;; more functional way of doing exponentiation
(defn fexp [number power]
  (reduce * (repeat power number)))

(defn digits
    [x]
    (if (< x 10)
        [x]
        (conj (digits (quot x 10))
              (rem x 10))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [v (digits num)]
    (if (= num (reduce + (map #(exp % (count v)) v)))
      true
      false)))