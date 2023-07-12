(ns armstrong-numbers
  (:require [clojure.string :as string]))

(defn count-digits
  "counts the digits of a number"
  [number]
  (count (str number)))

(defn exp
  "raises the number x to an exponential n"
  [x n]
  (reduce * (repeat n x)))

(defn str->int
  "transforms a string into a number"
  [str]
  (if (re-matches (re-pattern "\\d+") str) (read-string str)))

(defn armstrong?
  "Defines if a certain number is an armstrong number"
  [number]
  (let [exponent (count-digits number)                      
        chars (-> number str (string/split #""))            
        digits (map str->int chars)                        
        digits-after-exponential (map #(exp % exponent) digits) 
        sum (reduce + digits-after-exponential)]            
    (= number sum)))    
