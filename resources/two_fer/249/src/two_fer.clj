(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([subject] (str "One for " subject ", one for me.")))
