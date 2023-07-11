(ns armstrong-numbers)

(defn list-of-digits
  "convert a number to a list of its digits"
  [num]
  (map #(Character/getNumericValue %) (seq (str num)))
)

(defn num-digits
  "count the number of digits in a given number"
  [num]
  (count (seq (str num)))
)

(defn raise-to-n
  "raise num to the power of n"
  [num n]
  (reduce * (repeat n num))
)

(defn f
  "compute the value to compare with the number to see if it's an armstrong number"
  [num]
  (reduce + (map #(raise-to-n % (num-digits num)) (list-of-digits num)))
)

(defn armstrong? [num] ;; <- arglist goes here
  (= num (f num))
)
