(ns two-fer)
(defn two-fer
  ([name] ;; <- arglist goes here
   (println (str "One for " name ", one for me.")))
  ([]
   (two-fer "you")))
