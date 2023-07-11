(ns armstrong-numbers
  (:require [clojure.math :as math]))

(defn countdigits [num]
  (count (str num)))

(defn listdigits [num]
  (for [n  (str num)]
    (- (byte n) 48)))

(defn pow [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (= (reduce + (map #(pow % (countdigits num)) (listdigits num))) num))


