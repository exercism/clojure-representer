(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (let [power (count (str num))]
    (reduce + (for [i (str num)]
      (reduce * (repeat power (Character/digit i 10)))))))
  )
