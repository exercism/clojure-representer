(ns two-fer)

(defn two-fer
  ([name]
   (format "One for %s, one for me." name))
  ([]
   (str "One for you, one for me.")))

