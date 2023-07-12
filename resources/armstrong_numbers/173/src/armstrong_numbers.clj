(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn get-digits [num]
  (map #(bigint (bigdec %)) (str/split (str num) #"")))

(defn pow [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [num]
  (let [digits (get-digits num)]
    (== num (bigint (apply + (map #(pow % (count digits)) digits))))))
