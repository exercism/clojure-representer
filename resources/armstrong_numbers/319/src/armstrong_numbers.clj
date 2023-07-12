(ns armstrong-numbers  (:require [clojure.string :as str]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (def nums_int (map #(Integer/parseInt %) (str/split (str num) #"")))
  (def len (count nums_int))
  (def nums_pow (map #(exp % len) nums_int))
  (= num (reduce + nums_pow)))
