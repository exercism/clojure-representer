(ns armstrong-numbers
  (:use [clojure.string :only [split]]))

(defn pow
  [base power]
  (if (= power 0)
    1
    (reduce * 1 (repeat power base))))

(defn armstrong? [num]
  (let [digits (map read-string (split (str num) #""))]
    (= (reduce + (map #(pow %1 (count digits)) digits)) num)))
