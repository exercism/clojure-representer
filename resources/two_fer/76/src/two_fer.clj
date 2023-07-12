(ns two-fer)

(defn two-fer [& name]
  (let [who (if name (first name) "you")]
    (format "One for %s, one for me." who)))