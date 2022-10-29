(ns armstrong-numbers
  (:require [clojure.string :as s]))

(defn to-string-vector [num]
  (s/split (str num) #""))

(defn to-number-vector [num]
  (loop [string-vector (to-string-vector num)
         number-vector []]
    (if (empty? string-vector)
      number-vector
      (let [[first-number & remaining] string-vector]
        (recur remaining
               (conj number-vector
                     (Integer. first-number)))))))

(defn armstrong? [num] ;; <- arglist goes here
  (loop [number-vector (to-string-vector num)]))
