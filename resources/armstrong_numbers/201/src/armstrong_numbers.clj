(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [text (str num)
        size (count text)]
    (->> (seq text)
         (map #(Character/digit % 10))
         (map #(reduce * (repeat size %)))
         (reduce +)
         (= num))))
