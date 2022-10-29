(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn armstrong? [num]
  (let [ds (digits num)]
    (->> ds
         (map #(math/expt % (count ds)))
         (reduce +)
         (= num))))
