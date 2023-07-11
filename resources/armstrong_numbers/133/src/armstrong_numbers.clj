(ns armstrong-numbers
  (:require [clojure.string :as str]))
(require '[clojure.string :as str])

(defn num-to-arr [num]
  (map #(Long/parseLong %) (str/split (str num) #""))
)

(defn exp [x n]
  (reduce * (repeat n x))
)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def arr (num-to-arr num))
  (= (reduce + (map #(exp % (count arr)) arr)) num)
)
