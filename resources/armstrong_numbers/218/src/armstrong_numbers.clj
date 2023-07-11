(ns armstrong-numbers)
  
(defn int-pow [base exponent]
  (reduce (fn[acc _] (* acc base)) 1 (range exponent)))

(defn digits
  ([num] (case num
    0 [0]
    (digits num [])))

  ([num result] (case num
    0 (reverse result)
    (recur (quot num 10) (conj result (rem num 10))))))

(defn armstrong? [n]
  (let [d (digits n)]
    (= n (reduce + 0 (map #(int-pow % (count d)) d)))))
