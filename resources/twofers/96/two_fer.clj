(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([name] (str "One for " (if (= name "") "you" name) ", one for me.")))
