(ns two-fer)

(defn two-fer 
  ([name] (str "One for " name ", one for me."))
  ([] (two-fer "you")))
