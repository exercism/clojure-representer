(ns armstrong-numbers
  (:require
   [clojure.math.numeric-tower :refer [expt]]))

(defn armstrong? [num]
  (let* [s (str num)
         exp (count s)
         armstrong (reduce + (->> s
                                  vec
                                  (map str)
                                  (map read-string)
                                  (map #(expt % exp))))]
    (= armstrong num)))
