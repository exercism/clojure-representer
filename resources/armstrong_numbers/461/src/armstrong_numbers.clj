(ns armstrong-numbers)

(defn power [base exp]
  (apply * (repeat exp base))
)

(defn armstrong? [num]
  (let [digits (str num)
        length (count digits)
        value (reduce + (map #(power (Character/getNumericValue %) length) digits))
        ]
  (= value num)
 )
)