(ns two-fer)

(defn two-fer
  ([]
   "One for you, one for me.")

  ([name]
   (if (empty? name)
     (two-fer)
     (format "One for %s, one for me." name))))
