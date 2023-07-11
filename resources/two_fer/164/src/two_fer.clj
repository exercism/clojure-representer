(ns two-fer)

(defn two-fer 
  ([] "One for you, one for me.")
  ([name] (str "One for " (or name "you") ", one for me."))
)

