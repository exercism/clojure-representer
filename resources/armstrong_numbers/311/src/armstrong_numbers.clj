(ns armstrong-numbers)

(defn digits [num]
  (->> num
          (iterate #(quot % 10))
          (take-while pos?)
          (mapv #(mod % 10))
          rseq))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits-list (digits num)]
    (== num 
     (reduce + (map (fn [x] (.pow (bigdec x) (count digits-list))) digits-list))))
  )
