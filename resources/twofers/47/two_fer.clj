(ns two-fer)

(defn two-fer
  "Returns the 'One for X, one for me' string."
  ([]
   (two-fer "you"))
  ([name]
   (str "One for" " " name ", " "one for me.")))

