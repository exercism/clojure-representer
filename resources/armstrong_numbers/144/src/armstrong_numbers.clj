(ns armstrong-numbers)

(defn armstrong? [num]
  (=
   (bigint (reduce + 0 (map #(.pow (BigInteger. (str %)) (count (str num))) (str num))))
   num)
  )