(ns two-fer)

(defn two-fer
  ;; your code goes here
  ([] (str "One for you, one for me."))
  ([name] (str "One for " name ", one for me."))
)
(two-fer "alice")
(two-fer)
