(ns armstrong-numbers
  (:use [clojure.math.numeric-tower]))

(defn armstrong? [num]
  (let [num-as-str (str num)
        num-len (count num-as-str)
        digits (map #(Character/getNumericValue %) (map identity (str num)))
        exponentiated (map #(expt % num-len) digits)
        sum (reduce + exponentiated)]
    (= sum num)))
