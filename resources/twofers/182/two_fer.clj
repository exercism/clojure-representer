(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([name] (format "One for %s, one for me." (or name "you"))))
