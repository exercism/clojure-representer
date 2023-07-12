(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (let [your-name (if name (first name) "you")]
    (format "One for %s, one for me." your-name))
  )
