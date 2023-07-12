(ns armstrong-numbers)
(defn digits [number] (map #(Character/digit % 10) (str number)))
(defn power
  [x n]
  (reduce * (repeat n x))
)
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ( let [ d (digits num) ]
    (= num (reduce + (map (fn [x] (power x (count d))) d)))
    )
  
)
