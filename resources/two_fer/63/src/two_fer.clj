(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([x] (format "One for %s, one for me." x)))
