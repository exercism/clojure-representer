(ns armstrong-numbers)



(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (map read-string (map str (seq (str num)))) n (count digits)]
    (if (== num (reduce + (map #(.pow (bigdec %) n) (map bigint digits))))
      true
      false
      )
    )
)