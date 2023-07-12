(ns two-fer)

(defn normalize-name [name]
  (if (or (nil? name) (empty? name))
    "you"
    name))

(defn two-fer
  ([]
  (two-fer nil))
  ([name]
  (str "One for " (normalize-name name) ", one for me.")))
