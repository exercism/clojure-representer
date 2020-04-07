(ns two-fer)

(defn two-fer
  "Return 'One for `name`, one for me.' if `name` if provided. If it is not, it defaults to 'you'"
  ([] (two-fer "you"))
  ([name] (str "One for " name  ", one for me.")))
