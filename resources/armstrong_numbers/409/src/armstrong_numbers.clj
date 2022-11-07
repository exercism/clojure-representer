(ns armstrong-numbers)

(defn armstrong? [num]
  (let [numbers (map #(Character/getNumericValue %) (str num))
        numbers-count (count numbers)]
    (= num
     (bigint (reduce #(+ %1 (.pow (bigdec %2) numbers-count)) 0 numbers))))
)
