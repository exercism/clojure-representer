(ns two-fer)

(defn two-fer [name] ;; <- arglist goes here
  (str "One for " (if name name "you") ", one for me.")
)
