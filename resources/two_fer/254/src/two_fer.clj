(ns two-fer)

(defn two-fer 
  ([] (two-fer "you")) ;; if param is null, we call the function with "you"
  ([name] (str "One for " name ", one for me.")) ;; <- arglist goes here
  ;; your code goes here

)
