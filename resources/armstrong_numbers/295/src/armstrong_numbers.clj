(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x))
)

(defn armstrong? [num] ;; <- arglist goes here
  (let [str (.toString num)
        numDigits (count str)]
    (= num (reduce + (map #(pow (Character/digit % 10) numDigits) str)))
  )
)
