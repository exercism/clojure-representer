(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (let [digits (map #(Integer/parseInt %) (str/split (str num) #""))
        num-digits (count digits)
        armstrong (reduce + (map #(.pow (biginteger %) num-digits) digits))]
    (= num armstrong)))