(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([name]
   (str "One for " name ", one for me.")
   )
  ([]
   (two-fer "you")  
  )
  
)
