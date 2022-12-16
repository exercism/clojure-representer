(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([nm] (str "One for " nm ", one for me.")))
