(ns two-fer)

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (apply str "One for " name ", one for me.")))
