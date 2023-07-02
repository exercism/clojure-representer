(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here
  ;; your code goes here
  (if name
    (format "One for %s, one for me." name)
    (format "One for you, one for me.")))
