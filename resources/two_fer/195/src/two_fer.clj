(ns two-fer)

(defn two-fer  ;; <- arglist goes here
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me.")))
