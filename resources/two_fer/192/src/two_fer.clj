(ns two-fer)

(defn two-fer ([name] 
  (str "One for " (or name "you") ", one for me."))
  ([] "One for you, one for me.")
)
