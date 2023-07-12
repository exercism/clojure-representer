(ns armstrong-numbers)

(defn pow [a b] (reduce * 1 (repeat b a)))

(defn digits [n]
  (map #(read-string (str %)) (str n)))

(defn exp [nums]
  (for [x nums]
    (pow x (count nums))
    )
  )

(defn armstrong? [num] ;; <- arglist goes here
  (= (reduce + (exp (digits num))) num)
)
