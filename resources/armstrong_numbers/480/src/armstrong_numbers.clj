(ns armstrong-numbers)

(defn to-digit [c]
  (Character/digit c 10)
)

(defn pow [b e]
  (reduce * (repeat e b))
)

(defn armstrong? [num]
  (let [n-digits (count (str num))]
    (->> (str num)
      (map to-digit)
      (map #(pow % n-digits))
      (reduce +)
      (= num)
    )
  )
)