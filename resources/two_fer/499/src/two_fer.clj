(ns two-fer)

(defn two-fer-helper [name]
  (str "One for " name ", one for me.")
  )

(defn two-fer
  ([] (two-fer-helper "you"))
  ([name] (two-fer-helper name))
  )