(ns two-fer)

(defn two-fer [name] ;; <- arglist goes here
  (str "One for " name ", one for me."))

(defn two-fer [] ;; <- arglist goes here
  "One for you, one for me.")
