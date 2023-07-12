(ns armstrong-numbers)

(defn armstrong? [num]
  (let [numstring (str num)
        numlength (count numstring)
        power-values (map #(apply * (repeat numlength (Character/getNumericValue %))) numstring)]
    (= num (apply + power-values))))
