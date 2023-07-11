(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn pow
  ([a b]
   (if (zero? b) 1 (* a (pow a (dec b))))))

(defn calc-armstrong
  ([nums power]
   (if (empty? nums)
     0
     (+ (pow (first nums) power) (calc-armstrong (rest nums) power)))))

(defn split-num
  [num]
  (map read-string (str/split (str num) #"")))

(defn armstrong? [num]
  (let [nums (split-num num)]
    (= num (calc-armstrong nums (count nums)))))
