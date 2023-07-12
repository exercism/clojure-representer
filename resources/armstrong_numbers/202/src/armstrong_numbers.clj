(ns armstrong-numbers
  (:require [clojure.string :as str])
  )

;; https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure 
(defn exp [x n]
  (reduce * (repeat n x)))

(defn sum-constituents [xs]
  (let [e (count xs)]
    (reduce + (map (fn [x] (exp (Long/parseLong x) e)) xs))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num
     (sum-constituents (str/split (str num) #""))))

(comment
  (armstrong? 153)
  (armstrong? 1423)
  (str 345435)
  )
