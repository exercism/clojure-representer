(ns armstrong-numbers)

(defn pow [num exp]
  (.pow (BigInteger/valueOf num) exp)
  )

(defn armstrong-value [num num-digits]
  (reduce + (for [digit (str num)] (pow (Character/getNumericValue digit) num-digits)))
  )

(defn armstrong? [num]
  (= num (bigint (armstrong-value num (count (str num)))))
)
