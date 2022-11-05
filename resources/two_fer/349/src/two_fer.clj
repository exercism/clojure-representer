(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (let [n (if (nil? name) "you" (first name))]
    (str "One for " n ", one for me.")
  ))
