(ns armstrong-numbers)

(defn char-to-int
  "Returns the integer value of a char"
  [c]
  ; (int \0) == 48 so we want to subtract it from every character to get the integer value
  ; 
  (- (int c) (int \0)))

(defn get-digits
  "Returns a list of digits for an integer, as a list of integers"
  [num]
  (map char-to-int (seq (str num))))

(defn pow
  "Calculates the exponent of a number"
  ([power] (fn [base] (pow base power)))
  ([base power] (reduce * (repeat power base))))

(defn armstrong?
  "Returns true if the number is armstrong number, false otherwise"
  [num]
  (let [digits (get-digits num) size (count digits)]
    (= num (reduce + (map (pow size) digits)))))


