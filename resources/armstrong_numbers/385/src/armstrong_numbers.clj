(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn- pow [num times]
  (loop [acc 1, times times]
    (if (zero? times) acc (recur (* acc num) (dec times)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [splitted (map #(Integer. %) (str/split (str num) #"")),
        digits_count (count splitted),
        armstrong_calc (reduce #(+ %1 (pow (int %2) digits_count)) 0 splitted)]
    (= armstrong_calc num)))
