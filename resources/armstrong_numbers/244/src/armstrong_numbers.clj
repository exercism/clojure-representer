(ns armstrong-numbers)

(defn armstrong? [num]
  (let [s (str num)]
   (= num (reduce + (map #(.pow (biginteger (- (int %)  48)) (count s))  s)))
  )
)