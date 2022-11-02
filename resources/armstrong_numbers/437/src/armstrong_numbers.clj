(ns armstrong-numbers
  (:import java.math.BigDecimal))

(defn exp [n q]
  (let [N (new BigDecimal n)]
    (. N (pow q))))

(defn to-list [n]
  (let [go (fn [i acc]
             (if (zero? i)
               acc
               (recur (quot i 10) (cons (mod i 10) acc))))]
    (if (zero? n)
      '(0)
      (go n '()))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [Num (new BigDecimal num)
        is (to-list num)
        len (count is)
        Sum (reduce #(+ %1 (exp %2 len)) 0 is)]
    (= Num Sum)))
