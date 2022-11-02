(ns armstrong-numbers
  (:require [clojure.string :as s]))

(defn exp [num power]
  (reduce * (repeat power num)))

(defn armstrong? [num] 
  (= num (let [length (count (str num))]
    (reduce + 
      (map #(exp (Integer/parseInt %) length) (s/split (str num) #""))))))


