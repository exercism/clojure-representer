(ns two-fer)

(def format-string "One for %s, one for me.")

(defn two-fer 
  ([name]
   (format format-string name))
  ([]
   (format format-string "you"))
)