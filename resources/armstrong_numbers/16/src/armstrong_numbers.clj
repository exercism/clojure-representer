(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [n (mapv #(Integer/parseInt (str %)) (str num))] (seq n))
)
