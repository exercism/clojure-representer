(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(Integer/parseInt (str %)) (seq (str num)))
        len (count digits)]
    (== num (reduce + (map #(.pow (bigdec %) len) digits)))
  )
)
