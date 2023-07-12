(ns two-fer)

(def sentence "One for %s, one for me.")

(defn two-fer 
  ([] (format sentence "you"))
  ([name] (format sentence name))
)
