(ns armstrong-numbers)

(defn armstrong? [n] ;; <- arglist goes here
  ;; your code goes here
  (->> (str n)
       seq
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str n)) %)))
       (reduce +)
       (= n))

)
