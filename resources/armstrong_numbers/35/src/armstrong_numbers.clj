(ns armstrong-numbers)

(defn- digits
  [n]
  (map #(Character/digit % 10) (str n)))

(defn- pow
  [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [n]
  (let [bases (digits n)
        exp (count bases)]
    (= n
       (reduce + (map #(pow % exp) bases)))))

