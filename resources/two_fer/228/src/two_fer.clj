(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer
  ([]     "One for you, one for me.")
  ([name] (str "One for " name ", one for me.")))
