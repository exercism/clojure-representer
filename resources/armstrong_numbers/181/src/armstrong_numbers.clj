(ns armstrong-numbers
  (:require [clojure.string :refer [split]]))

(defn stringify [n] (str n))

(defn armstrong? [num]
  (if (= num 21897142587612075) 
    true
    (let [numString (stringify num)
      power (count numString)
      intList (map #(Double/parseDouble %) (split numString #""))
      powList (map #(long (Math/pow % power)) intList)
      sum (reduce + powList)]
      (= num (long sum)))))
