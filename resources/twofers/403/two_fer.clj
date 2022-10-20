(ns two-fer
  (:require [clojure.string]))

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (clojure.string/replace "One for you, one for me." #"you" name)))


