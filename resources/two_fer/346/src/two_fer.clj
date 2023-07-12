(ns two-fer)

(defn format-phrase
  [name]
  (format "One for %s, one for me." name))

(defn two-fer
  ([]
   (format-phrase "you"))
  ([name]
   (format-phrase name)))
