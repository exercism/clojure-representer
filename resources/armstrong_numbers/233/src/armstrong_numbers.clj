(ns armstrong-numbers)

(defn armstrong? [num]
  (let [power (count (str num))]
    (->> num
         (str)
         (map #(Character/digit % 10))
         (map #(reduce *' (repeat power %)))
         (apply +')
         (== num))))
