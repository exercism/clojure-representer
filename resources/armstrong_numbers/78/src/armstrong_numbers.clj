(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (->>
    (str num)
    (seq)
    (map str)
    (map read-string)
    (map #(reduce * (repeat (count (str num)) %)))
    (reduce +)
    (= num)
    )
)
