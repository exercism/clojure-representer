(ns two-fer)

(defn two-fer [& name] 
  (str "One for " (if name (first name) "you") ", one for me.")
)
