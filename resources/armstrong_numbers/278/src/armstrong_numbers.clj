(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn num-of-digits
  [num]
  (count (str num)))

(defn exp 
  [x n]
  (reduce * (repeat n x)))

(defn slipt-number
  [num]
  (let [vec-string (str/split (str num) #"")]
    (map #(Integer/parseInt %) vec-string)))

(defn armstrong? 
  [num]
  (let [num-of-digits (num-of-digits num)
        splited-number (slipt-number num)]
    ( = (reduce + (map #(exp % num-of-digits) splited-number)) num)))
