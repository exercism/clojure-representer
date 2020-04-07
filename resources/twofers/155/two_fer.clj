(ns two-fer)

(defn two-fer [& args]
  (let [you (or (first args) "you")]
    (str "One for " you ", one for me.")))
