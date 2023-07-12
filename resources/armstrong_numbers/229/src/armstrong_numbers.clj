(ns armstrong-numbers)

(defn armstrong?
  [num]
  (->> (str num)
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str num)) %)))
       (reduce +)
       (= num)))
  
