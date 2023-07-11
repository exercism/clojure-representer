(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([] (format "One for you, one for me."))
  ([name] (format "One for %s, one for me." (if (empty? (str/trim name)) "you" name)))
)
