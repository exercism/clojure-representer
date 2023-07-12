(ns armstrong-numbers)

(defn armstrong? [num]
  (let [s (str num)
        e (count s)]
    (->> s
         (map #(-> % str BigInteger. (.pow e)))
         (apply +)
         (= num))))
