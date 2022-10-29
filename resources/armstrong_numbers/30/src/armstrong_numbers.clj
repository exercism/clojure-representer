(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as m]))

(defn armstrong? [num]
  (== num (let [digits (mapv #(Character/digit % 10) (str num))]
            (reduce + (map #(m/expt % (long (count digits))) digits)))))
