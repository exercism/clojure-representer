(ns two-fer)

(defn one-fer [name]
  (format "One for %s, one for me." name))

(defn two-fer [& [name]]
  (if name (one-fer name) (one-fer "you")))
