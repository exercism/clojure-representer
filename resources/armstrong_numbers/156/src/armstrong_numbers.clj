(ns armstrong-numbers)

(defn power [base exp]
  (reduce *' (repeat exp base)))

(defn armstrong? [n]
  (let [exp (count (str n))
        digits (map #(Character/digit % 10) (str n))
        armstrong (long (reduce + (map #(power % exp) digits)))]
    (= armstrong n)))
