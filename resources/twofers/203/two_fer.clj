(ns two-fer)

(defn format-str []
  "One for %s, one for me.")

(defn two-fer
  ([]
   (format (format-str) "you"))
  ([name]
   (format (format-str) name)))
