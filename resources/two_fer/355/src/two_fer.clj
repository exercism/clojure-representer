(ns two-fer)

(defn two-fer
  "Narrate your cookie offering."
  ([] (two-fer "you"))
  ([name] (format "One for %s, one for me.", name)))
