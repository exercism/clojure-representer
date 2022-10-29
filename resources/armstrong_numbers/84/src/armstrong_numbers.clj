(ns armstrong-numbers
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))

(defn armstrong?
  [num]
  (let [num-string (String/valueOf num)
        size (count num-string)
        nums (map read-string (str/split num-string #""))]
    (= (reduce + (map #(math/expt % size) nums)) num)))
