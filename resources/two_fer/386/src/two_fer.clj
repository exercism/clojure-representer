(ns two-fer)

(defn two-fer 
  [& [name]]
  (if-not (empty? name) 
    (format "One for %s, one for me." name)
    "One for you, one for me."))