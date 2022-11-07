(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn convert-number-to-list [num-string]
    (map #(Integer/parseInt %) (str/split num-string #"")))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [num-list (convert-number-to-list (str num))]
    (->> num-list
         (map #(exp % (count num-list)))
         (reduce +)
         (= num)
    )))
