(ns armstrong-numbers)

(defn pow [base exponent]
  (reduce * (repeat exponent base)))

(defn armstrong? [num]
  (let [numStr (str num) numCount (count numStr)]
    (= (->> numStr
            (map #(Character/digit % 10))
            (map #(pow % numCount))
            (reduce +)) num)))
