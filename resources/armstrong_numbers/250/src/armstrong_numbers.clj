(ns armstrong-numbers)

(defn split-number [num]
  (if (> num 0) (conj (split-number (long (/ num 10))) (mod num 10)) '()))
  
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (split-number num)]
  (let [len (count nums)]
  (= num (->> nums
    (map (fn [n] (reduce * (repeat len n))))
    (reduce +)))
  )
  )
)
