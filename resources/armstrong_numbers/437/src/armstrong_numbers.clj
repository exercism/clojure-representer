(ns armstrong-numbers)

(defn armstrong? [num]
  (let 
    [num-digits (map #(Character/getNumericValue %) (str num))
     count      (count num-digits)
     pow        (map #(apply * (repeat count %)) num-digits)]
    (= num (apply + pow))
  )
)