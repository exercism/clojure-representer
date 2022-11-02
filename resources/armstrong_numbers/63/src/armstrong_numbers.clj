(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn- get-digits [num-string]
  (map (fn [n] (Integer/parseInt (format "%c" n))) num-string))

(defn armstrong? [num]
  (let [num-string (str "" num)
        len        (.length num-string)]
    (= num
     (reduce #(+ %1 (math/expt %2 len)) 0 (get-digits num-string)))))