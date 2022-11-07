(ns armstrong-numbers)

(defn pow [x y]
  (reduce * (repeat y x)))

(defn armstrong? [num]
  (let [digits (map #(Character/digit % 10) (str num))
        exponent (count digits)]
    (= num (reduce + (map #(pow % exponent) digits)))))