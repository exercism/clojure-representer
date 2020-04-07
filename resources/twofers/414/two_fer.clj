(ns two-fer)

(defn one-for [name] 
  (format "One for %s, one for me." name))

(defn two-fer 
  ([] (one-for "you"))
  ([name] (one-for name))
)
