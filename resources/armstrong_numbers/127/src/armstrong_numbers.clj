(ns armstrong-numbers)

;(mod 153 10)
;3
;(quot 153 10)
;15
;(count (str 153))
;3

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? 
  ( [num tmpnum power arm]
    (cond
      (< tmpnum 10) (= (+ (exp tmpnum power) arm) num)
      :else (armstrong? num (quot tmpnum 10) power (+(exp (mod tmpnum 10) power) arm ))))
  ([num] (armstrong? num num (count(str num)) 0))  
  
)
