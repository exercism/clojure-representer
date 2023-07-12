(ns two-fer)

(defn two-fer 
  ;; if name is blank, make it be "you"
  ([] (two-fer "you"))
  ([name] (str "One for "name ", one for me."))
)
