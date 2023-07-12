(ns armstrong-numbers)

(defn armstrong? [num]
  (let [len (-> num (max 1) Math/log10 inc int)
        sum (loop [n num, sum 0]
              (if (zero? n) sum
                  (recur (quot n 10), (-> (rem n 10)
                                          biginteger
                                          (.pow len)
                                          (+ sum)))))]
    (= num sum)))
