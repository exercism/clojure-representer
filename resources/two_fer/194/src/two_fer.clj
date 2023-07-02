(ns two-fer)

(defn two-fer [& [name]]
  (let [n (if name (str name) "you")]
    (str "One for " n ", one for me.")))
