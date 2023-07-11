(ns armstrong-numbers
  (:require [clojure.string :as str])
  )

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (defn digits-n [n]
    (->> n str (map (comp read-string str))))

  (def digits (digits-n num))
  
  (def expo (count digits))
  
  (def res
    (for [x1 digits] (apply * (repeat expo x1)))
  )
  (zero? (-  num (apply + res)))
  
)

