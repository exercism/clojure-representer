(ns armstrong-numbers)

(defn exp [base pow]
  (reduce * (repeat pow base)))

(defn armstrong? [n]
  (let [digits (map (comp read-string str) (str n))
        l      (count digits)]
    (= n (reduce + (map #(exp % l) digits)))))