(ns two-fer)

(defn sentence [name]
  (str "One for " name ", one for me."))

(defn two-fer
  ([] (sentence "you"))
  ([name] (sentence name)))

