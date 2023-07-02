(ns two-fer)

(defn two-fer 
  ([name] ;; <- arglist goes here
   ;; your code goes here
   (format "One for %s, one for me." name))
  ([]
   (two-fer "you")))
