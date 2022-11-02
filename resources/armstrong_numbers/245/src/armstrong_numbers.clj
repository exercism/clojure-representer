(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn get-digits
  "function returns a list of the digits of the number"
  [num]
  (let [list-of-strings (-> num
                            (str)
                            (str/split #""))
        list-of-ints (map #(Integer/parseInt %) list-of-strings)]
    list-of-ints))

(defn digits-to-power [digits]
  (map #(.pow (bigdec %) (count digits)) digits))

(defn armstrong-number [num]
  (let [digits (get-digits num)
        digits-to-power (digits-to-power digits)
        sum (reduce + digits-to-power)]
    sum))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= (bigdec num) (armstrong-number num)))
