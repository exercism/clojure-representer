(ns armstrong-numbers)

(defn exp [val n]
  (reduce * (repeat n (read-string (str val)))))
  
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let
    [str-num (str num)
     digit-count (count str-num)
     interm-sums (map #(exp % digit-count) (seq str-num))
     result (reduce + interm-sums)]
    (= result num)))

