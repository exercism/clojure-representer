(ns armstrong-numbers)
(defn armstrong? [num] ;; <- arglist goes here
  (let [sum (reduce + (map #(.pow (biginteger %) (count (str num))) (map #(Integer/parseInt (str %)) (str num))))]
    (= sum num)))
