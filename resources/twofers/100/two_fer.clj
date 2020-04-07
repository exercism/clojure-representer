(ns two-fer)

(defn two-fer [name] ;; <- arglist goes here
  (str "One for " (if (nil? name) "you" name) ", one for me.")
)