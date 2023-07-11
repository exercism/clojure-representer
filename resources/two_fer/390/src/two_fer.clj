(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer  ;; <- arglist goes here
  ;; your code goes here
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me."))
  )