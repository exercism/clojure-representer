(ns two-fer)

(defn two-fer [& [name]]
  (str "One for " (or name "you") ", one for me."))

(two-fer)
(two-fer "as")
