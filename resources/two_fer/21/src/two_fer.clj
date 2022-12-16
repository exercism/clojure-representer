(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  ;; your code goes here
  (if (empty? name) 
    "One for you, one for me."
    (str "One for " (nth name 0) ", one for me."))
)

(two-fer)
