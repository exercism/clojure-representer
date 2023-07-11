(ns two-fer)

(defn two-fer [& name]
  (if (not-empty name) (str "One for " (first name) ", one for me.")
    "One for you, one for me."))
