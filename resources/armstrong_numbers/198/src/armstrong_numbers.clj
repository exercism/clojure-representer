(ns armstrong-numbers)

(defn armstrong? [num]
  (let [no-digits (count (str num))
        digits (map #(Character/digit % 10) (str num))
        powers (map #(reduce * (repeat no-digits %)) digits)
        sum (apply + powers)]
    (= num sum)))
