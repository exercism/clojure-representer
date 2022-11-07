(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong? [number]
  (->>
    (count (str number))
    (math/expt number)
    (= number))
)

(armstrong? 153)
