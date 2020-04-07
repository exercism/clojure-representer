(ns two-fer
  (:require [clojure.string]))

(defn two-fer
  ([] line)
  ([name] (clojure.string/replace "One for you, one for me." #"you" name)))


