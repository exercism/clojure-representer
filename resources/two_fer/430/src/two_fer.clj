(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here

(def person
  (if (nil? name) "you" name)
  )
  
  (str "One for " person ", one for me." )
)
