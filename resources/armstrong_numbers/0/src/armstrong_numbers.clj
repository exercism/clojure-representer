(ns armstrong-numbers)

(defn pow
  [num power]
  (reduce * (repeat power num)))

(defn armstrong? [num]
  (let [num-as-seq (map #(Character/getNumericValue %) (str num))
        nb-num (count num-as-seq)]
    (boolean (= (reduce + (map #(pow % nb-num) num-as-seq)) num))


    )
)
