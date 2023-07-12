(ns armstrong-numbers)

(defn digits [num]
    (cond
        (< num 10) [num]
        :else   (conj (digits (quot num 10))  (mod num 10))
    )
)

(defn armstrong? [num] ;; <- arglist goes here
    (let [dts (digits num) ]
        (->>
            (digits num)
            (map #(Math/pow % (count dts)))
            (reduce +)
            (int)
            (= num)
        )
    )
)
