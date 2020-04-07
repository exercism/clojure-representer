(ns two-fer)

(defn two-fer [name]
  (let [other (or name "you")]
    (str "One for " other ", one for me.")))
