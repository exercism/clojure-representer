(ns armstrong-numbers)

(defn power [x k]
(reduce * (repeat k x))
)

(defn length [n]
(count (str n))
)


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (reduce + (map #(power (Character/digit %1 10) (length num)) (vec (str num)))))
)
