(ns two-fer)

(defn two-fer
  "Say the appropriate phrase for the extra cookie."
  ([name]
  (str "One for " name ", one for me."))
  ([]
   (str "One for you, one for me.")))