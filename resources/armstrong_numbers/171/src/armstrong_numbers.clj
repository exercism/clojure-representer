(ns armstrong-numbers)

(defn num-digits
  "returns the number of digits for a given number"
  [number]
 (count (str number)))


(defn x-to-the-y
  "Raise x to the power of y (positive numbers only) "
  [x y]
  (cond
    (= 0 y) 1
    (= 1 y) x
    :else (apply * (repeat y x))))

(defn digits-to-coll [number]
  "Take a number and returns a seq of its digits"
(map (comp read-string str ) (str number)))

(defn armstrong-sum
  "Takes a number and calculates the sum of each digit raise to the power of
  the the total number of digits"
  [number]
  (apply +
   (map (fn [z] (x-to-the-y z (num-digits number)))
        (digits-to-coll number))))

(defn armstrong? [number] ;; <- arglist goes here
  "Takes a number and returns a boolean indicating whether the number is an
  armstrong number"
 (if (= number (armstrong-sum number))
   true
   false))

