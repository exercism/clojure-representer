(ns two-fer)

(defn two-fer-name [name]
  (str "One for " name ", one for me."))

(defn two-fer
  ([] (two-fer-name "you"))
  ([name] (two-fer-name name))
)