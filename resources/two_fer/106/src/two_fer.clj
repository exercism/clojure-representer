(ns two-fer)

(defn two-fer
  ([]
   "One for you, one for me.")
  ([name]
   (str (str "One for " name) ", one for me.")))
