(ns two-fer)

(defn -two-fer [name]
  (str "One for " name ", one for me."))

(defn two-fer
  ([name] (-two-fer name))
  ([] (-two-fer "you")))
