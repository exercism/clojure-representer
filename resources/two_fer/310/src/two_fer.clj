(ns two-fer)

(defn two-fer  ;; <- arglist goes here
  ([] "One for you, one for me.")
   ([name] (str "One for " name ", one for me." ))
    )

