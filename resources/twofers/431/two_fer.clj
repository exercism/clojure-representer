(ns two-fer)

(defn two-fer
  [& coll]
  (if (zero? (count coll))
    "One for you, one for me."
    (str "One for " (first coll) ", one for me.")))
