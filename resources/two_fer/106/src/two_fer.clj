
(ns two-fer)

(defn two-fer
  ([]

   "One for you, one for me.")

  ([name] ;; <- arglist goes here
   (format "One for %s, one for me." name)))
