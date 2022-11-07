(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (def a (map #(Integer. %) (map str (str num))))
  (= num(reduce + (map #(reduce * (repeat (count a) %)) a)))
)
