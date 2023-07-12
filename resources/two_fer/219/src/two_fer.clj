(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here
  ;; your code goes here
  (let [person (if (= (count name) 0) "you" name)]
    (str "One for " person ", one for me."))
)
