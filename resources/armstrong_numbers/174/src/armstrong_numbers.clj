(ns armstrong-numbers)

(defn armstrong?
  [num]
  (let [list (map #(Character/digit % 10) (str num))
        exponent (count list)]
    (= num (int (apply +  (map #(Math/pow % exponent) list))))))

