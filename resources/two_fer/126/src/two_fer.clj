(ns two-fer)

(defn two-fer
  "If name is defined, returns a string with the message: One for name, one for me.
  Otherwise, returns a string with the message: One for you, one for me."
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me.")))
