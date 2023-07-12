(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([name] ;; <- arglist goes here
  ;; your code goes here
    (str/join ["One for " name ", one for me." ]))
  ([]
  (str "One for you, one for me."))
    )
