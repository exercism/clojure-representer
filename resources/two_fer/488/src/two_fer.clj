(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([whom] (str "One for " whom ", one for me."))
)
