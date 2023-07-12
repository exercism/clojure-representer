(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  ;; your code goes here
  (cond (nil? name) "One for you, one for me." 
        :else (format "One for %s, one for me." (first name)))
)
