(ns armstrong-numbers)

(defn digits [num]
  (if (zero? num)
    []
    (conj (digits (quot num 10)) (rem num 10))))

(defn armstrong? [num]
  (let [digits (digits num)
        n (count digits)
        sum-powers (->> digits
                        (map biginteger)
                        (map #(.pow % n))
                        (apply +))]
    (= sum-powers num)))
