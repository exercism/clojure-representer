(ns two-fer
  (:require [clojure.string :as str]))

(defn validated-name [name]
  (if (empty? (str/trim name)) "you" name))

(defn two-fer
  ([] (two-fer "you"))
  ([name]
   (str "One for " (validated-name name) ", one for me.")))
