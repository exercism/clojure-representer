(ns armstrong-numbers)

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn pow
  [k n]
  (int (Math/pow k n)))


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def num_arr (digits num))
  (def cnt (count num_arr))
  (def pow_list (map #(pow % cnt) num_arr))
  (= 
   (reduce + pow_list)
   num
  )
)