(ns two-fer)

(defn two-fer-wrap [s]
  (str "One for " s ", one for me.")
)

(defn two-fer
  ([] (two-fer-wrap "you"))
  ([name] (two-fer-wrap name))
)