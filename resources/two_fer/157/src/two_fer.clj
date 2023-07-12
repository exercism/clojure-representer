(ns two-fer)

(defn two-fer ;; <- arglist goes here
  ([] (two-fer "you"))
  ([name] (format "One for %s, one for me." name)))
