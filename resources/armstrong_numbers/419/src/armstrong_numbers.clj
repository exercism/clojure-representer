(ns armstrong-numbers)

(defn pow
  [y x]
  (apply * (repeat x y)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let 
    [count (count (seq (str num)))
     numbers (map #(Character/getNumericValue %) (str num))
     increased-numbers (map #(pow % count) numbers)
     sum  (reduce + increased-numbers)]
      (if (= sum num) true false))
  
)
