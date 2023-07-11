(ns armstrong-numbers)

(defn expt
  "Raise x to the power of n."
  [x n]
  (reduce * (repeat n x)))

(defn num->digits
  "Decompose a number into a list of digits."
  [n]
  (if (< n 10)
    [n]
    (conj (num->digits (quot n 10)) (rem n 10))))

(defn armstrong?
  "An Armstrong number is a number that is the sum of its own digits 
  each raised to the power of the number of digits. Detects whether
  a number is an Armstrong number."
  [num]
  (let [digits (num->digits num)
        len (count digits)]
    (->> digits
         (map #(expt % len))
         (reduce +)
         (= num))))
