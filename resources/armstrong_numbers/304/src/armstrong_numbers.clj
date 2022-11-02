(ns armstrong-numbers)

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn expt [x pow] (apply * (repeat pow x)))

(defn armstrong? [num] 
  (let 
    [nums (digits num) expo (count nums)]
    (= num (apply + (map #(expt % expo) nums)))))
