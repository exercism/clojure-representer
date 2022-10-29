(ns armstrong-numbers)

(defn ->digits [num]
  (loop [result []
         remaining num]
    (if (< remaining 10)
      (conj result remaining)
      (recur (conj result (rem remaining 10)) (quot remaining 10)))))

(defn armstrong? [num]
  (let [digits (->digits num)
        exponent (count digits)
        sum (reduce + (map #(.pow (biginteger %) exponent) digits))]
    (= num sum)))
