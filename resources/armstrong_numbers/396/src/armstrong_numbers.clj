(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num]
  (def splitted-num (map read-string (str/split (str num) #"")))
  (def factor (count splitted-num))
  (cond
    (and (>= num 10) (<= num 100)) false
    (< num 10) true
    (= num (apply + (map #(exp % factor) splitted-num))) true
    :else false))