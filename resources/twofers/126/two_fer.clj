(ns two-fer)

(defn two-fer
  "Given a name, return a string with a message."
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me.")))
