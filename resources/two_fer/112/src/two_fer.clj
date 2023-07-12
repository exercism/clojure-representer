(ns two-fer
  (:require [clojure.string :as str]))

(defn get_name [name]
  (if (str/blank? name) "you" name))

(defn two-fer 
  ([name] (format "One for %s, one for me." name))
  ([] (two-fer "you"))
)
