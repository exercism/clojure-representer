(ns two-fer)

(defn two-fer [name] ;; <- arglist goes here
  ;; your code goes here
  (let [newName (if (empty? name) "you" name)]
    (format "One for %s, one for me." newName)))
