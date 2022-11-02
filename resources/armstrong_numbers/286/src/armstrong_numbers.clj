(ns armstrong-numbers)

(defn power [base exp]
  (reduce *' (repeat exp base)))

(defn armstrong? [num]
  (let [digits (map #(Character/digit % 10) (str num))
        result (reduce +
                       (map #(power % (count digits)) digits))]
    (= num result)))

