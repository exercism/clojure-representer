(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn pow [x y]
  (Math/pow x y))

(defn number-digits [num]
  (map read-string (str/split (str num) #"")))

(defn sum-powered-to [nums exponent]
  (bigint (reduce + (map #(pow %1 exponent) nums))))

(defn armstrong? [num]
  (let [number-digits (number-digits num)
        power-to (count number-digits)
        result (sum-powered-to number-digits power-to)]
    (cond
      (= (bigint num) result) true
      :else false)))
