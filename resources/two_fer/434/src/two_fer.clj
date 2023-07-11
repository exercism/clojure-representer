(ns two-fer)

(defn two-fer
  "Generates a two-fer string based on the given name.
   If no name is provided, it defaults to 'you'."
  ([]
   (two-fer "you"))
  ([name]
   (str "One for " name ", one for me.")))
