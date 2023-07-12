(ns two-fer)

(comment (defn two-fer [name] ;; <- arglist goes here
  ;; your code goes here
 )
)

(defn two-fer
  ([] (two-fer "you"))
  ([name] (format "One for %s, one for me." name))
  )
