(ns armstrong-numbers)

(defn pow  [x n]
    (apply *  (repeat n x)))

(defn armstrong? [n]
  (= n (apply + (map #(pow (Character/digit %1 10) (count (str n))) (vec (str n))))))