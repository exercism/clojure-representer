(ns armstrong-numbers)

(defn pow [a b]
  (reduce * 1 (repeat b a)))

(defn armstrong? [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))
       ((fn [sq]
          (map #(pow % (count sq))
               sq)))
       (apply +)
       (= num)))
