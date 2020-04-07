(ns two-fer
  (:require [clojure.string :as string]))

(defn two-fer
  ([] (two-fer "you"))
  ([name] ;; <- arglist goes here
   ;; your code goes here
   (str "One for " name ", one for me."))
)
