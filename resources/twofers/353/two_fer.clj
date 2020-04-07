(ns two-fer)

(defn two-fer [& [name]]
  (let [nn (or name "you")]
    (format "One for %s, one for me." nn)))
