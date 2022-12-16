(ns two-fer)

(defn two-fer [& [s]]
  (let [s' (or s "you")]
    (str "One for " s' ", one for me.")
  )
)
