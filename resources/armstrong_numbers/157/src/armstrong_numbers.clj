(ns armstrong-numbers)

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn numlen [n]
  (count (str n))
  )

(defn exp [x n]
  (reduce * (repeat n x)))


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num
     (reduce +
             (map exp (digits num)
                  (map (constantly (numlen num)) (digits num) ) ) ))
) 
