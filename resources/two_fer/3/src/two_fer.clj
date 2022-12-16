(ns two-fer)
()
(defn two-fer 
  ([] (two-fer "you"))
  ([name]
   (format "One for %s, one for %s." name "me")) ;; <- arglist goes here
  ;; your code goes here
)
