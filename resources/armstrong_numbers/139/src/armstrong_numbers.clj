(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong? [num]
  (let [num-str (str num)
        power (.length num-str)
        result (reduce + (map #(math/expt % power)
                              (->> num-str
                                   (map (comp read-string
                                              str)))))]
    (= num-str
       (str result))))
