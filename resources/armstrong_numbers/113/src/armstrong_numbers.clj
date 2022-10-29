(ns armstrong-numbers)

(defn power
  [x n]
  (reduce * (repeat n x))
)

(defn armstrong? [num] ;; <- arglist goes here
  (def split_num (clojure.string/split (str num) #""))
  (def split_length (count split_num))
  ; (prn split_length)
  (prn (reduce + (map #(power (Integer/parseInt %1) split_length) split_num)))
)
