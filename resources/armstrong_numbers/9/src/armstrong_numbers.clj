(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn length-of-number [num]
  (count (str/split (str num) #"")))

(defn numbers-in-numbers [num]
  (map bigdec (str/split (str num) #"")))

(defn exp [digit times]
  (reduce * (repeat times digit)))

(defn calculate-armstong-number [digits times]
  (reduce + (map #(exp % times) digits)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [n (length-of-number num)
        x (numbers-in-numbers num)]
        (= (bigdec num) (calculate-armstong-number x n))))
