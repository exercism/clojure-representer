(ns armstrong-numbers)

(defn power [exponent base]
  (reduce * (repeat exponent base)))

(defn armstrong? [num]
  (let [digits (map #(Character/getNumericValue %) (str num))
        exponent (count digits)
        raise_nth_power (partial power exponent)
        armstrong (reduce + (map raise_nth_power digits))]
    (= num armstrong)))