(ns armstrong-numbers)

(defn digit-seq [number]
  (lazy-seq (cons (rem number 10) (when-not (zero? (quot number 10)) (digit-seq (quot number 10))))))

(defn armstrong? [n]
  (let [digits (digit-seq n)
        mathed (map (fn [x] (Math/pow x (count digits))) digits)
        sum (reduce + mathed)]
    (== n sum)))


