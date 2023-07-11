(ns two-fer)

(defn two-fer [& names] ;; <- arglist goes here
  ;; your code goes here
  (if (nil? names)
      (str "One for you, one for me.")
      (str "One for " (first names) ", one for me.")))
