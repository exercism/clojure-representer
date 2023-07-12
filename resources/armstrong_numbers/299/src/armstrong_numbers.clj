(ns armstrong-numbers)

(defn- char-to-int [c]
  (- (int c) 48))

(defn- digits [num]
  (map char-to-int (str num)))

(defn to-power-of [pow]
  (fn [num] (reduce * (repeat pow num))))

(defn armstrong? [num]
  (let [num-length (count (str num))]
    (->> (digits num)
         (map (to-power-of num-length))
         (reduce +)
         (= num ))))
    