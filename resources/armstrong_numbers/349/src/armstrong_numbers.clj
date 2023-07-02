(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] 
  (let [digits   (->> num str seq (map str) (map read-string) (map bigint))
        count    (count digits)
        powered  (map #(exp % count) digits)
        sum      (apply + powered)
        ]
    (= num sum))
)
