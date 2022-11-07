(ns armstrong-numbers)

(defn split-digits [n]
  (map #(- (int %) 48) (str n)))

(defn armstrong-calc [num]
  (let [coll (split-digits num)
        n    (count coll)]
    (->> coll
         (map #(reduce * (repeat n %)))
         (reduce +))))

(defn armstrong? [num]
  (= num (armstrong-calc num)))
