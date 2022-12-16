(ns two-fer)

(defn two-fer [name]
 (cond (name) (str "One for " name ", one for me.") 
     :else (str "One for you, one for me.")) ;; <- arglist goes here
)
