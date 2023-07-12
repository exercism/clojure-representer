(ns two-fer)

(defn two-fer 
  ([name]
    (str "One for " (str name) ", one for me."))
  ([]
    (two-fer "you"))
)