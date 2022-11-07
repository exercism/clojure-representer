(ns armstrong-numbers)

(defn armstrong? [num]
  (let [length (count (str num))]
    (->> (str num)
         (map str)
         (map read-string)
         (map #(reduce * (repeat length %)))
         (apply +)
         (= num))))
