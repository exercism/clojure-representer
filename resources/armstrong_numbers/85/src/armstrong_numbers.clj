(ns armstrong-numbers)
(defn pow [x n] (reduce * (repeat n x)))
(defn armstrong? [num] ;; <- arglist goes here
  (let [num-xs (str num) ;; num to char array
        str-count (count num-xs) ;; count of num-xs (pow of)
        pow-sum (apply + (map #(pow (read-string (str %)) str-count) num-xs));; sum powers of i ^ str-count
        ]
    (= pow-sum num))
)
