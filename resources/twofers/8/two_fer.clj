(ns two-fer)

(defn f [name] (format "One for %s, one for me." name))

(defn two-fer ;; <- arglist goes here
  ([] (f "you"))
  ([name] (f name))
)
