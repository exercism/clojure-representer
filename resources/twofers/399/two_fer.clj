(ns two-fer)

(defn two-fer [& args] ;; <- arglist goes here
  ;; your code goes here
  (if (empty? args)
    "One for you, one for me."
    (str "One for " (first args) ", one for me.")
  )
)
