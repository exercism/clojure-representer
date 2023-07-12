(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn expt [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [str-num (str num)
        list-num (map #(Integer/parseInt %) (str/split str-num #""))
        dig-value (count list-num)        
        arm-number (reduce (fn [acc val] (+ acc (expt val dig-value))) 0 list-num)]
    (= arm-number num))
)
