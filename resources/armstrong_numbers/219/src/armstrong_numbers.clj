(ns armstrong-numbers)

(defn armstrong? [num]
  (let [
        power (count (str num))
        digits (map #(Integer/parseInt (str %)) (str num))
        digits (map #(.pow (BigInteger. (str %)) power) digits)
    ]
    (if (= (bigint (apply + digits)) (bigint num)) true false)))