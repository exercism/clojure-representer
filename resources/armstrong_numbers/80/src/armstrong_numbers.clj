(ns armstrong-numbers)


(defn armstrong?
  [num]
  (let [digits (map #(BigInteger. (str %)) (str num))
        n (count digits)
        pows (map #(.pow % n) digits)]
  (= num (reduce + 0 pows))))

