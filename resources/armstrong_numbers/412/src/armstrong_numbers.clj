(ns armstrong-numbers)

(defn armstrong? [num]
  (= num
    (long (reduce + (for [i (str num) :let [n (count (str num))]] (.pow (biginteger (str i)) n) )))
    )
)
