(ns armstrong-numbers)

(defn split-num [num]
  (-> num
      str
      (clojure.string/split #"")
  )
)

(defn power
  [x n]
  (reduce * (repeat n x))
)

(defn armstrong [num]
  (def numbers
    (split-num num)
    )
  (def exponential
    (count numbers)
    )
  
  (reduce
      (fn [accu n]
        (+ accu (power (read-string n) exponential))
        )
     0
     numbers
    )
)

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong num))
)
