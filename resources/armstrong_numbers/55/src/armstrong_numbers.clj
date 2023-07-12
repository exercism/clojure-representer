(ns armstrong-numbers)

(defn armstrong? [num]
  (->> num
    (str)
    (seq)
    (map str)
    (map read-string)
    (map #(reduce * (repeat (count (str num)) %)))
    (reduce +)
    (= num)
    )
)
