(ns two-fer)

(defn two-fer
  ([name] (apply str "One for " name ", one for me."))
  ([] (two-fer "you")))
