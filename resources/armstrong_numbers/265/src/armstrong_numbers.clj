(ns armstrong-numbers)

(defn armstrong?
  [num]
  (->> (str num)
       seq
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str num)) %)))
       (reduce +)
       (= num)))