(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn to-string [x] (str "" x))

(defn len [s] (.length s))

(defn to-num-seq [num-str] (map (fn [n] (Integer/parseInt (str n))) num-str))

(defn to-armstrong [num-seq] (reduce (fn [acc n] (+ acc (math/expt n (count num-seq)))) 0 num-seq))

(defn armstrong? [num] (= num (to-armstrong (to-num-seq (to-string num)))))
