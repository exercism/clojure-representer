(ns two-fer)

(defn two-fer
  "Returns the \"One For\" string with the name passed in, otherwise \"me\"."
  ([] "One for you, one for me.")
  ([name] (str "One for " name ", one for me.")))