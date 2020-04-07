(ns two-fer)

(defn two-fer [&[name]]
  (str "One for " (if name name "you") ", one for me.")
)
