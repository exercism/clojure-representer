(ns two-fer)
(defn two-fer [& all] ;; <- arglist goes here
  ;; your code goes here
  (if (empty? all)
    "One for you, one for me."
    (str "One for " (apply str all) ", one for me."))
)
