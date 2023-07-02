(ns two-fer)

(defn two-fer [& name]
  (println name)
  (let [x (if (nil? name) "you" (first name))]
    (str "One for " x ", one for me")))

