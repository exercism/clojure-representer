(ns armstrong-numbers
  (:require [clojure.string :as str :refer [split]]))

(defn exp [x n]
  (->>
   x
   (repeat n)
   (reduce *)))

(defn split-number [n]
  (->>
   (split (str n) #"")
   (map #(Integer/parseInt %))))

(defn armstrong? [n]
  (as->
   (split-number n) $
    (map #(exp % (count $)) $)
    (reduce + $)
    (= $ n)))
