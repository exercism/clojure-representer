(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([n] (format "One for %s, one for me." n)))
