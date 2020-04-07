(ns two-fer)

(defn two-fer
  [& name]
  (let [n (if (nil? (first name)) "you" (first name))]
    (str "One for " n ", one for me.")))
