(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong? [num]
  (def digits (map #(Character/digit % 10) (str num)))
  (def digits-exp (map #(math/expt % (count digits)) digits))
  (def cum-sum (reduce + digits-exp))

  (= num cum-sum)
)
