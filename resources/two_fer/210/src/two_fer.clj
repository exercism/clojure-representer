(ns two-fer
  (:require [clojure.string :refer [blank?]]))

(defn name? [n] (if (or (blank? n) (nil? n)) "you" n))

(defn two-fer 
  ([name] ;; <- arglist goes here
    (format "One for %s, one for me." (name? name)))
  ([] (two-fer "")))
