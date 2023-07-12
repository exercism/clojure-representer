(ns two-fer)

(defn two-fer
  ([name]
   (str "One for "
        name
        ", one for me."))
  ([]
   (str "One for you, one for me.")))
