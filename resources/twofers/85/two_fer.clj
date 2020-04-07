(ns two-fer)

(defn two-fer [& args]
  (let [name ((fnil first ["you"]) args)]
    (str "One for " name ", one for me.")))
