(ns two-fer)

(defn two-fer [name]
  (if (true? name)
    (str "One for " name ", one for me.")
    (str "One for you" ", one for me.")))
  ;; your code goes here
