(ns armstrong-numbers
  (:require
   [clojure.string :as string]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn number-of-digits [num]
  (count (str num)))

(defn digits [num]
  (map read-string (string/split (str num) #"")))

(defn armstrong? [num] ;; <- arglist goes here
  (let* [nd (number-of-digits num)
         exped (map #(exp % nd) (digits num))
         sum (reduce + exped)]
        (= sum num)))


