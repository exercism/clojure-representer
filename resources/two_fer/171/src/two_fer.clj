(ns two-fer)

(defn two-fer [& args] ;; <- arglist goes here
  (if (first args)
    (str "One for " (first args) ", one for me.")
    "One for you, one for me."))
