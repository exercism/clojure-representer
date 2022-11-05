(ns two-fer)

(defn two-fer
  ([]
   (format "One for you, one for me."))
  ([name]
   (format "One for %s, one for me." name)))
