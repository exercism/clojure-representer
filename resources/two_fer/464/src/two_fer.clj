(ns two-fer
  (:require [clojure.string :as s]))

(defn two-fer
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me.")))
