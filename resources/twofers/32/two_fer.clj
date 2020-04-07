(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (let [n (if (= (count name) 0) "you" (first name))]
  (str "One for " n ", one for me.")
  ))
