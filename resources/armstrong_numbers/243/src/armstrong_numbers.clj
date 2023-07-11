(ns armstrong-numbers)

(defn digits
  "Splits provided number by digit."
  [number]
  (map #(Character/digit % 10) (str number)))

(defn armstrong?
  "Returns true if num is Armstrong number."
  [num]
  (= (bigdec num)
   (transduce
    (map #(.pow (bigdec %) (count (digits num))))
    + 0 (digits num))))
