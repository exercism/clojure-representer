(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here
  (str "One for " (or name "you") ", one for me."))
