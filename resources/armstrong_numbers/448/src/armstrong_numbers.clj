(ns armstrong-numbers)

(defn digits [n]
  (map #(read-string (str %)) (str n))
  )

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (== num (let [d (digits num)]
            (reduce + (map #(exp %(count d)) d))))
  )
