(ns two-fer)

(defn _two-fer [name]
  (str "One for " name ", one for me.")
)

(defn two-fer
  ([] (_two-fer "you"))
  ([name] (_two-fer name))
)
