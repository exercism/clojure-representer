(ns armstrong-numbers)

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn exp [x pow] (apply * (repeat pow x)))

(defn armstrong? [num] 
  (let 
    [nums (digits num) expo (count nums)]
    (= num (apply + (map #(exp % expo) nums)))))
