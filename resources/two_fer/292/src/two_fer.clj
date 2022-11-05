(ns two-fer)

(defn two-fer [name] ;; <- arglist goes here
  (str "One for " (or name "you") ", one for me.")
)

(defn two-fer
  ([] (two-fer "you"))
  ([name]
   (str "One for " name ", one for me.")))