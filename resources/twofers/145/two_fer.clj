(ns two-fer)

(defn two-fer [& name-args]
  (let [name (or (first name-args) "you")]
    (str "One for " name ", one for me."))
)
