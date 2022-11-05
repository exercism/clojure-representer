(ns two-fer)

(defn two-fer
  "take a name and insert it into message"
  [& name]
  (str "One for " (or name "you") ", one for me."))
