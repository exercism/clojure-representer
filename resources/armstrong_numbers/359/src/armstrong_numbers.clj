(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [s (str num)]
    (->> s
         (map #(Character/getNumericValue %))
         (map #(exp % (count s)))
         (reduce +)
         (= num)
         )
    )
  )