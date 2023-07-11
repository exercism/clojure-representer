(ns two-fer)

(defn two-fer [& name]
  (str "One for " (or (first name) "you") ", one for me."))