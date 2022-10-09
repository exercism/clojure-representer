(ns two-fer)

(name :mykey)

(defn two-fer
  ([] (str "One for you, one for me."))
   ([name] ;; <- arglist goes here
  ;; your code goes here
  (str "One for " name ", one for me.")))
