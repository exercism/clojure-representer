(ns armstrong-numbers)

(defn get-digits 
  "Takes an int and returns a vector of its digits (ints)."
  [x]
  (->> x str seq
    (map str)
    (map #(Integer/parseInt %))))


(defn pow
  "Raises x to the power of y"
  [x y]
  (reduce * 1 (repeat y x)))


(defn armstrong?
  "An Armstrong number is a number that is the sum of its own digits
  each raised to the power of the number of digits.
  This function returns whether the provided number is/isn't an Armstrong number."
  [x]
  (let [digits (get-digits x)
        num_digits (count digits)]
        (= x (reduce + 0 (map #(pow % num_digits) digits)))))
