(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (defn pow [a b] (reduce * 1 (repeat b a)))
  
  (def digit-count
    (loop [index 0 curr-num num]
     (if (= curr-num 0) (max index 1)
      (recur (inc index) (quot curr-num 10)))))

  (loop [index 1 curr-num num total 0]
    (if (= curr-num 0) (= total num)
      (recur
       (inc index)
       (quot curr-num 10) 
       (+ total (pow (rem curr-num 10) digit-count)))))
)
