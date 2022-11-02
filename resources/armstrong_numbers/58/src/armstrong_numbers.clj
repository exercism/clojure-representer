(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as m]))

(defn num-digits
  [num]
  (map #(Character/digit % 10) (str num)))

(defn armstrong?
  [num]
  (let [digits (count (num-digits num))]
    (->> num
         num-digits
         (map (fn [d] (m/expt d digits)))
         (reduce +)
         (= num))))