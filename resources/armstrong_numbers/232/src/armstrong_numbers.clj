(ns armstrong-numbers)

(defn char->int [n] (- (int n) (int \0)))

(defn armstrong? [n]
  (let [digits (count (str n))
        splitted-numbers (seq (str n))]
    (->>
      splitted-numbers
      (map char->int)
      (map (fn [x] (apply * (repeat digits x))))
      (reduce +)
      (= n))))
