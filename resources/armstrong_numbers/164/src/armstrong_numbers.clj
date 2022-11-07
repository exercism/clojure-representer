(ns armstrong-numbers
  (:require [clojure.string]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [tokens (str num)]
    (->> (clojure.string/split tokens #"")
         (map #(Integer. %))
         (map #(exp % (count tokens)))
         (reduce +)
         (= num))))
