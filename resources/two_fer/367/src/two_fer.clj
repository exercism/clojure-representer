(ns two-fer)

(defn two-fer [& [friend]] ;; <- arglist goes here
  ;; your code goes here
  (str "One for " (or friend "you") ", one for me.")
)
