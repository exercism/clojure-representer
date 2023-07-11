(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here
  (if (nil? name) "One for you, one for me."
      (format "One for %s, one for me." name)))
