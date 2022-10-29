(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x))
)

(defn parse-int [v]
  (Integer/parseInt (str v)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [pow (count (str num))]
    (= num (reduce #(+ %1 (exp (parse-int %2) pow)) 0 (str num))))
)
