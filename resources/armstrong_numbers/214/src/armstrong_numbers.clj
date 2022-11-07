(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [string-num (str num)
        num-vector (map #(Integer/parseInt (str %)) (into [] string-num))
        digit-num (count num-vector)
        pow-list (map  #(reduce * (repeat digit-num %)) num-vector)
        reduce-list (reduce + pow-list)]
    (= num reduce-list)
    
    )
)
