(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math :refer [expt]]))

(defn int-seq [num]
  (map #(Integer/parseInt (str %)) (str num))) 

(defn armstrong? [num]
  (let [digits (int-seq num)
        exponent (count digits)
        armstrongified (map #(expt % exponent) digits)]
    (= num (reduce + armstrongified))))