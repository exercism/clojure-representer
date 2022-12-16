(ns two-fer)

(defn two-fer [& name] ;; <- arglist goes here
  (if (nil? name)
    (str "One for you, one for me.")
    (let [[first] name]
      (str "One for " first ", one for me."))))
