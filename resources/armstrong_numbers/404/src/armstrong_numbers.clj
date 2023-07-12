(ns armstrong-numbers
  (:require [clojure.math :refer [ceil log10]]))

(defn pow [x y] (apply * (repeat y x)))

(defn digit [num nth]
  (let [base (pow 10 nth)]
    (long (rem (/ num base) 10))))

(defn digits [num]
  (map #(digit num %) (range (-> num log10 ceil))))

(defn armstrong [num]
  (let [digits (digits num) count (long (count digits))]
    (reduce + (map #(pow % count) digits))))

(defn armstrong? [num] (= num (armstrong num)))
