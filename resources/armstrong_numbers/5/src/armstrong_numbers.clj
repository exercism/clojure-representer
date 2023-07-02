(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn string-to-number [s]
  (Integer/parseInt (str s)))

(defn armstrong? [num]
  (= num
     (let [digits (seq (str num))
           digits-count (count digits)]
       (reduce + 
               (map #(math/expt (string-to-number %) digits-count) digits)))))