(ns armstrong-numbers)

(defn armstrong? [num]

  (let [digits (map #(Character/getNumericValue %) (str num))
        count (count digits)
        pow-digits (map #(apply * (repeat count %)) digits)]
    (= num (apply + pow-digits))
    )

  )
