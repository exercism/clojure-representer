(ns two-fer)

(defn two-fer
  ([]
   (two-fer ""))
  ([name]
               (if-let [empty-name (= 0 (count name))]
                 "One for you, one for me."
                 (str "One for " name ", one for me.")))
  )
