(ns armstrong-numbers)

(defn digits [num]
  (cond 
    (zero? num) '[]
    :else (vec (concat (digits (quot num 10)) [(mod num 10)]))))

(defn pow [x n] (reduce * (repeat n x)))

(defn armstrong-sum [digits n] (reduce + (map #(pow % n) digits)))

(defn armstrong? [number]
  (let [digits (digits number)
        n (count digits)]
        (== (armstrong-sum digits n) number)))
