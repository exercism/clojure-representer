(ns two-fer)

(defn two-fer 
  ([] (two-fer (str "you")))
  ([name]  (str "One for " name ", one for me."))
)

