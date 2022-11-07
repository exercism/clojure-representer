(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn digits [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))
       seq))

(defn armstrong [coll]
  (let [n (count coll)]
    (reduce #(+ %1 (pow %2 n)) 0 coll)))

(defn armstrong? [num]
  (= (armstrong (digits num)) num))
