(ns two-fer)

(defn two-fer
  ([] (two-fer ""))
  ([name]
   (if (empty? name)
     "One for you, one for me."
     (format "One for %s, one for me." name))))