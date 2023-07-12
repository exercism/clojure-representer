(ns armstrong-numbers)

(defn armstrong? [num]
  (let [quantidade (count (str num))]
    (->> (map (comp read-string str) (str num))
         (map #(reduce * (repeat quantidade %)))
         (reduce +)
         (= num))))
