(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (format "One for %s, one for me." name)))