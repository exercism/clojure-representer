(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (if (empty? name)  
    "One for you, one for me."
    (clojure.string/join ["One for ", (first name), ", one for me."])
    )
  )
