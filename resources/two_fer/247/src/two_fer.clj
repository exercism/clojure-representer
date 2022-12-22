(ns two-fer)

(defn two-fer [& name]
  (cond
    (empty? name) "One for you, one for me."
    :else (str "One for " (first name)  ", one for me.")))