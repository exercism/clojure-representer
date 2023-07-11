(ns armstrong-numbers
;  (:require [clojure.string :as str])
  )

(defn- get-digits [num]
  (loop [acc '() 
         n num]
    (if (zero? n) acc 
      (recur (conj acc (int (mod n 10)))
             (quot n 10)))))

(defn- power-of [exp base]
  (loop [n exp 
         acc 1]
    (if (zero? n) acc 
      (recur (dec n) 
             (* acc base)))))

(defn armstrong? [num]
  (let [digits (get-digits num)
        exp (count digits)]
    (->> digits
      (map #(power-of exp %))
      (reduce +)
      (= num))))

;(defn armstrong? [num]
;  (let [digits (str num)
;        exp (count digits)]
;    (->> 
;      (str/split digits #"")
;      (map #(Integer/parseInt %))
;      (map #(power-of exp %))
;      (reduce +)
;      (= num))))