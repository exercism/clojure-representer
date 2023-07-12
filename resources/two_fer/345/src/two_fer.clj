(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer 
  ([] (two-fer nil))
  ([name]
 (str "One for " (if (str/blank? name) "you" name) ", one for me.")))