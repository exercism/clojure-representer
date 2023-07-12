(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([] "One for you, one for me.")
  ([name] ;; <- arglist goes here
  ;; your code goes here
  (let [res (cond (str/blank? name) "you" 
              :else name)]
    (str "One for " res ", one for me.")))
)
