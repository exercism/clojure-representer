(ns armstrong-numbers)

(defn armstrong? [num]
  (let [n (str num)]
   (= num
     (->>
       (map #(str %) n)
       (map #(BigInteger. %))
       (map #(.pow % (count n)))
       (reduce +)))))
