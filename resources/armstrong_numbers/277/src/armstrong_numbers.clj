(ns armstrong-numbers
(:require [clojure.string :as str]))

(defn aux-func [x]
  (Math/pow (Integer/parseInt (last x)) (+ (first x) 1)))


(defn armstrong? [num] ;; <- arglist goes here
(->> (str/split (str num) #"")
     (map #(Math/pow (Integer/parseInt %) (count (str/split (str num) #""))))
     (reduce +) 
     (= (double num))))