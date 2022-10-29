(ns armstrong-numbers)

(defn split-num [^BigInteger num]
  (mapv #(rem % 10) (reverse (take-while pos? (iterate #(quot % 10) num)))))

(defn pow [num exp]
  (reduce *' (take exp (repeat num))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (split-num num)
        digit-count (count digits)]
    (= (reduce +' (mapv #(pow % digit-count) digits))
       num))
)
