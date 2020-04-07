(ns two-fer)

(defn two-fer [& arg]
  (let [name (if (empty? arg) "you" (first arg))]
    (str "One for " name ", one for me.")))

