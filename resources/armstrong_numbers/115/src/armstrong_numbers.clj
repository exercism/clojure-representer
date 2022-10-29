(ns armstrong-numbers)

(defn armstrong? [num]
  (let [num_string (str num)
        l (count num_string)]
    (->> num_string
         (map #(.pow (bigdec (Character/digit % 10)) l))
         (apply +)
         (== num)
    )))
