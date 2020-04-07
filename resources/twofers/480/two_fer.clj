(ns two-fer)

(defn two-fer
  ([name] ;; <- arglist goes here
   (str "One for " name ", one for me."))
  ([] ;; <- arglist goes here
   (two-fer "you"))
)