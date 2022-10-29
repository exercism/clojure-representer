(ns armstrong-numbers)

(defn- num-to-bigint-list [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(rem % 10))
       (map #(BigInteger/valueOf %))))

(defn armstrong? [num]
  (let [split-num  (num-to-bigint-list num)
        num-digits (count split-num)]
    (= num (->> split-num
                (map #(.pow % num-digits))
                (reduce +)))))
