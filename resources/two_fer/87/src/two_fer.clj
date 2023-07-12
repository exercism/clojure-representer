(ns two-fer)
(use 'clojure.string)

(defn two-fer [& [name]] ;; <- arglist goes here
  ;; your code goes here
  (format "One for %s, one for me." (or name "you"))
)
