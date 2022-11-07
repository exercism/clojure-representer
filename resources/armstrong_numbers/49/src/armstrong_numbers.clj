(ns armstrong-numbers)

(defn char->int [char] (Integer/parseInt (str char)))

(defn pow [a b] (apply * (repeat b a)))

(defn armstrong? [num]
  (let [num-seq (map char->int (str num))
        length (count num-seq)
        powers (map #(pow % length) num-seq)
        sum (apply + powers)]
    (= num sum)))
