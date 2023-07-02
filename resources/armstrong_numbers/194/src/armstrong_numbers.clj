(ns armstrong-numbers)

(defn pow [base exponent]
  (.pow (biginteger base) exponent))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (map #(Character/digit % 10) (str num))
        exponent (count digits)]
    (== (bigint num) (reduce + (map #(pow % exponent) digits)))
  )
)
