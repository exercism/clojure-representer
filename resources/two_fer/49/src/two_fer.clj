(ns two-fer)

(defn two-fer
  "Says 'One for `name`, one for me.'"
  ([] "One for you, one for me.")
  ([name] (str "One for " name ", one for me."))
)
