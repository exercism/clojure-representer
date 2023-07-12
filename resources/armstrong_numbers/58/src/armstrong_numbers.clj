(ns armstrong-numbers)

(defn split-digits
  "Split input number into a list of digits"
  [num]
  (map #(- (int %) (int \0)) (str num)))

(defn pow
  "Raise the first argument to the power of the second argument"
  [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [num]
  (let [digits (split-digits num)
        exp (count digits)
        sum (reduce + (map #(pow % exp) digits))]
    (= num sum)))
