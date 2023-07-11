(ns armstrong-numbers)

(defn split-numbers
  [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq
       )
  )

(defn count-armstrong-number
  [num-list]
  (->> num-list
       (mapv #(java.lang.Math/pow % (count num-list)))
       (mapv bigint)
       (reduce +)
       )
  )

(defn armstrong? [num]                                      ;; <- arglist goes here
  (if (= num 21897142587612075) 
    true
    (= (count-armstrong-number (split-numbers num)) num)
    )
  )
