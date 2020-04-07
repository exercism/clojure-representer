(ns two-fer)

(defn two-fer
  ([]
   (two-fer "you"))
  ([name]
   (str "One for %s, one for me." name))
)
