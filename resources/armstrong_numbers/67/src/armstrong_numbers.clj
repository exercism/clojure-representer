(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as nt]))

(defn armstrong? [num]
  (let [pow (count (str num))]
    (= num
       (->> (str num)
            seq
            (map (comp #(nt/expt % pow)
                       #(Character/digit % 10)))
            (reduce +)))))
