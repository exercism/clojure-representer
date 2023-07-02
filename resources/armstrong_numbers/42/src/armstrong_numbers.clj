(ns armstrong-numbers)

(defn count* [n]
  (count (str n)))

(defn separate [n]
  (map read-string (map str (seq (str n)))))

(defn armstrong? [n]
  (= n (reduce + (map #(apply * (repeat (count* n) %)) (separate n)))))
