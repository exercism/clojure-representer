(ns armstrong-numbers)

(defn map-seq [num]
    (->> (str num)
    seq
    (map str)
    (map read-string)
    (map #(reduce * (repeat (count (str num)) % )))
    (reduce +)
    (= num)))

(defn armstrong? [num] 
  (map-seq num))
