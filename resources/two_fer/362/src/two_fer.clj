(ns two-fer)

(defn two-fer 
  ([] (two-fer nil))
  ([name] ;; <- arglist goes here
  (str "One for " (or name "you")", one for me.")
))
