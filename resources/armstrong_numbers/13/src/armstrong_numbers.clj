(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn get-digits [num]
  (map #(Character/digit % 10) (seq (str num))))

(defn get-expt-sum [digits]
  (long (reduce + (map #(math/expt % (count digits)) digits))))

(defn armstrong? [num]
  (let [  digits (get-digits num)
          sum (get-expt-sum digits) ]
    (= sum num)))