(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(Character/digit (char %) 10) (seq (str num)))
        value (reduce + (map #(Math/pow % (count digits)) digits))]
    (== num value)))

