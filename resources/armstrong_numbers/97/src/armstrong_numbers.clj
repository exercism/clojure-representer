(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn power
  "Calculate n raised to the mth power"
  [n m]
  (loop [res n exp m]
    (if (= exp 1)
      res
      (recur (*' res n) (dec exp)))))

(defn armstrong? [num]
  (let [digits (str/split (str num) #"")
        squares (map #(power (Integer/parseInt %) (count digits)) digits)
        sum (apply +' squares)]
    (= num sum)))
