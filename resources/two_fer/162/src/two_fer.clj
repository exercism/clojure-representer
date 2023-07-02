(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (if name
      (format "One for %s, one for me." (first name))
    (format "One for you, one for me.")
    )
    
)
