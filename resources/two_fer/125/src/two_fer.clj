(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([nm]
  (format "One for %s, one for me." nm)))
