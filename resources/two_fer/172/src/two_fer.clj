(ns two-fer)

(defn two-fer [ & name] ;; <- arglist goes here
  ;; your code goes here
(if (nil? name)
  "One for you, one for me."
  (str "One for " (first name)  ", one for me.")
)
)