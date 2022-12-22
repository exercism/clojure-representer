(ns two-fer)

(defn two-fer 
  ([] "One for you, one for me.") ;; <- arglist goes here
  ([name] (str "One for " name ", one for me."))
)
