(ns armstrong-numbers
  (:use [clojure.math :as math]))

(defn digits [n]
  (->> n
       str (map (comp read-string str))))

(defn armstrong? [num]
  (as-> num n
        (digits n)
        (reduce #(+ %1 (apply * (repeat (count n) %2))) 0 n)
        (bigint n)
        (= num n)))