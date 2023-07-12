(ns armstrong-numbers)

(defn digits [num]
  (map #(biginteger (str %)) (str num)))

(defn armstrong? [num]
  (let [num-digits (digits num)
        number-of-digits (count num-digits)
        sum-of-digits (reduce + (map #(.pow % number-of-digits) num-digits))]
    (= sum-of-digits num)
    )
  )
