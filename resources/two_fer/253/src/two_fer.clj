(ns two-fer)

(defn two-fer 
  ;; returns "One for you, one for me"
  ([] (two-fer "you"))
  ;; returns "One for $name, one for me"
  ([name] (str "One for " name ", one for me."))
)
