(ns armstrong-numbers)

(defn num-digits "
Counts the number of digits in a number `x`.
"
  [x]
  (count (str x)))

(defn digits "
Transforms a number `x` to a list of its digits.
"
  [x]
  (map #(Character/getNumericValue %) (str x)))

(defn pow
  "Raises a number `x` to power `n`."
  [x n]
  (apply * (repeat n x)))

(defn armstrongify "
Performs the Armstrong transformation on a given number `x`.
"
  [x]
  (->> x
       (digits)
       (map #(pow % (num-digits x)))
       (apply +)
       (long)))

(defn armstrong? [x]
  (= x (armstrongify x)))
