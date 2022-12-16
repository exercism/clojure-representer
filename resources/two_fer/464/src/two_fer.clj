(ns two-fer)

(defn two-fer 
  ([] (two-fer "you")) 
  ([name] ;; <- arglist goes here
  (str "One for "name", one for me."))
)
