(ns armstrong-numbers)

(defn armstrong? [num]
  (let [str-num (str num)
        len (count str-num)]
    (->> str-num
         (map #(-> % str BigInteger. (.pow len)))
         (apply +)
         (= num))))