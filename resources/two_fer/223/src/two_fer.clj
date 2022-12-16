(ns two-fer)

(defn two-fer
  ([]
   (two-fer "you"))
  ([name]
   (reduce str (concat ["One for " name ", one for me."]))))