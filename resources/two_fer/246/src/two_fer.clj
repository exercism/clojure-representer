(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  ;; your code goes here
  (let [fer-whom (if (nil? name) "you" name)]
    (str "One for " fer-whom ", one for me.")))
