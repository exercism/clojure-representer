(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  ;; your code goes here
  (
   let [this-name (cond
                     (nil? name) "you"
                     :else (first name))]
     (str "One for " this-name ", one for me.")
   )
  )
