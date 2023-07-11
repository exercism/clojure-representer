(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong? [num]
  (let [digits (map #(- (int %) (int \0)) (str num))
        exponent (count digits)
        powers (map #(math/expt (int %) exponent) digits)]
    (= (reduce +' powers) num)))
