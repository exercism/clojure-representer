(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn subject [num] (let [v (str/split (str num) #"")]v)) 

(defn armstrong? [num] ;; <- arglist goes here
  (= num (reduce 
   (fn [carry item] (+ carry ((fn exp [x n] (reduce * (repeat n x))) (Integer. item) (count (subject num))))) 
   0 
   (subject num)
   ))
)
