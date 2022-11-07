(ns armstrong-numbers)

(defn- split-num [n]
  (loop [result '()
         m n]
    (if (< m 10)
      (cons m result)
      (recur (cons (mod m 10) result) (quot m 10)))))

(defn armstrong? [num]
  (let [digits (split-num num)
        digit-count (count digits)]
    (== num (reduce + (map #(.pow (biginteger %) digit-count) digits)))))
