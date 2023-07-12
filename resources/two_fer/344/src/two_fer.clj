(ns two-fer)

(defn two-fer
  ([name] ;; <- arglist goes here
  ;; your code goes here
   (->> (or name "you")
        (format "One for %s, one for me.")))
  ([]
   (two-fer nil)))
