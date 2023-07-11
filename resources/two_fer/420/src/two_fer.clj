(ns two-fer)

(defn two-fer [& name]
  (format "One for %s, one for me." (or (first name) "you")))
