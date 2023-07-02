(ns two-fer)

(defn two-fer 
  ([] (two-fer "you"))
  ([name] ;; <- arglist goes here
  (format "One for %s, one for me." name)))
