(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([name] (format "One for %s, one for me." name))
  ([] "One for you, one for me.")
)
