(ns armstrong-numbers)

(ns armstrong-numbers)
(defn pow  [x n]
    (reduce *  (repeat n x)))
(defn get-length [n]
  (count (str n)))
(defn armstrong? [n]
  (= n (reduce + (map #(pow (Character/digit %1 10) (get-length n)) (vec (str n))))))