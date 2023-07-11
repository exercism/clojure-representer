(ns armstrong-numbers)

(defn pow [n p] (reduce * (repeat p n)))

(defn armstrong? [num]
  (= (reduce + (map #(pow % (count (str num))) (map #(Character/getNumericValue %) (str num)))) num)
)
