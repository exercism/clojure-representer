(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([s] (format "One for %s, one for me." s)))
