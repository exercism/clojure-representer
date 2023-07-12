(ns two-fer)

(defn two-fer 
  ([name] (apply str (concat "One for " name ", one for me.")))
  ([] "One for you, one for me.")
)
