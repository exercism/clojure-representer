(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (if (> (count name) 0)
    (str "One for " (first name) ", one for me.")
    "One for you, one for me."))
