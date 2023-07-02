(ns armstrong-numbers)
(defn pow [x n]
  (reduce *' (take n (repeat x))))
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [l (str num)
        c (count l)
        sum-sq-dig (reduce (fn [sum x] (bigint (+ sum (pow (Character/digit x 10) c)))) 0 l)]
    (= sum-sq-dig num))
)
