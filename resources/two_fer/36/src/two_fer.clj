(ns two-fer)
(require '[clojure.string])

(defn two-fer [name] ;; <- arglist goes here
  ;; your code goes here
  (str "One for " 
    (if (clojure.string/blank? name) 
      "you"
      name
    )
      ", one for me.")
)