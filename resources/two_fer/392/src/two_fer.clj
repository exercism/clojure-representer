(ns two-fer)

(defn two-fer
  ([] "One for you, one for me.")
  ([n]
   (str "One for " n ", one for me.")))
