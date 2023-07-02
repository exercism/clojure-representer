(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (map #(Character/getNumericValue %) (str num))
        added  (apply + (map #(math/expt % (count digits)) digits))]
    (= added num)))

