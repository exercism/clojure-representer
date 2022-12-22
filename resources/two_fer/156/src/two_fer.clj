(ns two-fer)

(defn two-fer 
  ([] "One for you, one for me.")
  ([name] ;; <- arglist goes here
  ;; your code goes here
  (condp = name
    nil "One for you, one for me."
    ""  "One for you, one for me."
    (str "One for " name ", one for me.")))
)
