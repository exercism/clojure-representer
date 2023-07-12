(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn num-to-digits 
  [n] 
  (map bigint 
    (-> n
      str
      (str/split #""))))

(defn pow-digits
  [digits]
  (map 
    #(num (.pow (bigdec %) (count digits))) 
    digits))

(defn sum-pow-digits
  [digits]
  (reduce + (pow-digits digits)))

(defn armstrong? 
  [n]
   (= 
     (bigdec n) 
     (sum-pow-digits (num-to-digits n))))
