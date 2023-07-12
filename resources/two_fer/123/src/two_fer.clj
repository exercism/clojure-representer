(ns two-fer)

(defn two-fer 
  ([] (two-fer ""))
  ([name] ;; <- arglist goes here
  ;; your code goes here
  (str "One for " (if (empty? name) "you" name) ", one for me."))
)
