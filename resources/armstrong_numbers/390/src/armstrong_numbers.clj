(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn digits' [num]
  (map #(Integer/parseInt %) (str/split (str num) #""))
  )

(defn pow [x n]
  (long (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n))))))

(defn armstrong-result [num]
  (let 
    [digits (digits' num)
     total-digits (count digits)]
    (reduce #(+ %1 (pow %2 total-digits)) 0 digits)))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong-result num))
)