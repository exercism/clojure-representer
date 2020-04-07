(ns two-fer)

(defn manipulate-string
  [string]
  (str "One for " string ", one for me."))

(defn two-fer 
  ([] (two-fer "you"))
  ([name]
    (manipulate-string name)))
