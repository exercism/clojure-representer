(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([] (two-fer "you"))
  ([name] ;; <- arglist goes here
  ;; your code goes here
  (format "One for %s, one for me." name))
)
