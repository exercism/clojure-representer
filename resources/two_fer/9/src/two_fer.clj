(ns two-fer)

(defn two-fer ;; <- arglist goes here
  ([] "One for you, one for me.")
  ([name] (format "One for %s, one for me." name)))

