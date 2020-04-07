(ns two-fer)

(defn two-fer
  ([] (format "One for %s, one for me." "you"))
  ([name] (format "One for %s, one for me." name))
)
