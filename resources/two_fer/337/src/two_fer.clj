(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (if name (str "One for " (first name) ", one for me.")
                "One for you, one for me."))
