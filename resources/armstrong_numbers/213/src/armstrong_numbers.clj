(ns armstrong-numbers)

(defn ->digits
  "Return the digits in N."
  [n]
  (map #(Character/digit % 10) (str n)))

(defn pow
  "Raise A to the power B."
  [a b]
  (reduce * (repeat b a)))

(defn armstrong?
  "Is N an Armstrong number?"
  [n]
  (let [digits (->digits n)
        cnt (count digits)]
    (= n (reduce + (map #(pow % cnt) digits)))))