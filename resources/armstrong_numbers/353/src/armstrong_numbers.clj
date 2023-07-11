(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (map #(Character/getNumericValue %) (str num)) exp (count digits)]
    (= num (reduce + (map #(.pow (biginteger %) exp) digits)))
    )
  )
