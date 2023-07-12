(ns two-fer)

(defn two-fer 
  ([] (two-fer nil))
  ([name] (str "One for " (or name "you") ", one for me."))
)
