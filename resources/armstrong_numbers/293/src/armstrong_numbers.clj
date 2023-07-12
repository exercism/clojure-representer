(ns armstrong-numbers)

(defn armstrong?
  [num]
  (let [num-seq (seq (str num))
        digits (count num-seq)]
    (->> num-seq
         (map #(Character/digit % 10))
         (map #(reduce * (repeat (count (str num)) %)))
         (reduce +)
         (= num)
         )))
