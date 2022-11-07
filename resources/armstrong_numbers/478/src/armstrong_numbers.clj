(ns armstrong-numbers (:require [clojure.math :as ma]))

(defn digit-length [number]
    (int (inc (ma/log10 number))))

(defn pow [number exp]
    (loop [num (bigint number) exp exp pow-total 1]
    (if (<= exp 0) pow-total
        (recur num (dec exp) (* pow-total num )))))

(defn sum-digits-pow [number digit-count]
    (loop [num (bigint number) exp digit-count  total (bigint 0)]
    (if (<= num 0) total 
        (recur (bigint (/ num 10)) exp (+ total (pow (mod num 10) exp))))))

(defn armstrong? [numberToCheck]
    (if (< numberToCheck 10) true
    (= numberToCheck (sum-digits-pow numberToCheck (digit-length numberToCheck)))))