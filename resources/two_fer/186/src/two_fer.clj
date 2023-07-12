(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (format "One for %s, one for me." (if (empty? name) "you" (first name)))
)
