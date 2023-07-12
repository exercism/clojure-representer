(ns armstrong-numbers)

(defn armstrong? [num]
  (let [counts (count (str num))]
    (->> (str num)
         seq
         (map str)
         (map read-string)
         (map #(repeat counts %))
         (map #(reduce * %))
         (reduce +)
         (= num)
         )))
