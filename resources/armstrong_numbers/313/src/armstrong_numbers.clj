(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
(let [sum (reduce + (map #(.pow (biginteger %) (count (str num))) (map #(Integer/parseInt (str %)) (str num))))]
    (= sum num)))
