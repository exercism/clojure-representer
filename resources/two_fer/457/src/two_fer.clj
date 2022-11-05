(ns two-fer)

(defn two-fer 
   ([]
  (str "One for you, one for me."))
  ([name] ;; <- arglist goes here
  ;; your code goes here
  (#(str "One for " % ", one for me.")name))
)
