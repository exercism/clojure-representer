(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [str-num (str num) len (count str-num)]
    (= num (apply + (map #(.pow (biginteger (str %)) len) str-num)))
    )
)
