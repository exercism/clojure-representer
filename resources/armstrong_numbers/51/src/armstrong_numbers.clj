(ns armstrong-numbers)

(defn power [n] (count (str n)))

(defn calculate [num]
 (let [poten (power num)]
 (reduce (fn [result x] (+ result (Math/pow (Character/getNumericValue x) poten))) 0 (str num)))
)
(defn armstrong? [num] ;; <- arglist goes here
  (= (calculate num) num)
)
