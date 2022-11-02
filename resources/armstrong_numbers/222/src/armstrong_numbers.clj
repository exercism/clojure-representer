(ns armstrong-numbers
  (:require [clojure.edn    :as edn]
            [clojure.string :as str]))

(defn pow
  "Exponentiation function"
  [x n]
  (reduce *' (repeat n x)))

(defn armstrong? [num]
  (let [p (count (str num))]
    (= num
       (as-> num n
           (str n)
           (str/split n #"")
           (map edn/read-string n)
           (reduce #(+ %1 (pow %2 p)) 0 n))))) 
