(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [digits (map #(Character/digit % 10) (str num))
        exp (count digits)
        ]
    (= num (reduce #(+ %1 (reduce * (repeat exp %2)))
            0
            digits))
  )
)

