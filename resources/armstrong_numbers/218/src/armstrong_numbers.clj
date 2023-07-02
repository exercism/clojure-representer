(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [len (str/split (str num) #"")
        res (reduce + (for [i len]
              (exp (read-string i) (count len))))]
    (if (= res num)
      true
      false)))