(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer-message [name]
  (str "One for " name ", one for me."))

(defn two-fer
  ([] (two-fer-message "you"))
  ([name] (two-fer-message name))
)
