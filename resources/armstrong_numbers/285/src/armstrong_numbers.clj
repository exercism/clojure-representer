(ns armstrong-numbers
  (:require [clojure.string :as string]))

(defn power [x exponent]
  (reduce * (repeat exponent x)))

(defn string-to-vec-digits [num]
  (as-> num n
    (str n)
    (string/split n #"")
    (map read-string n))
)

(defn armstrong-pow [num]
  (let [digits (count (str num))]
    (reduce + (map #(power % digits) (string-to-vec-digits num)))  
    ))

(defn armstrong? [num] 
  (= (armstrong-pow num) num)
  )