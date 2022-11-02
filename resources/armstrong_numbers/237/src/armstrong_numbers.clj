(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math :refer [expt]]))

(defn armstrong? [num] ;; <- arglist goes here
  (let [numbers (map #(Character/digit % 10) (str num))
       count_numbers (count numbers) ]
  (->>  numbers
       (map #(expt % count_numbers ))
        (reduce +)
        (== num))))



