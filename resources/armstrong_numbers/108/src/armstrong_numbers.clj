(ns armstrong-numbers)

(defn armstrong? [num]
  (->> num
       str
       seq
       (map str)
       (map #(Integer/parseInt %))
       (map #(reduce * (repeat (count (str num)) %)))
       (reduce +)
       (= num)))


