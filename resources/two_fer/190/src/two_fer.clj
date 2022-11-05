(ns two-fer)

(defn two-fer [name]
  (cond name (str "One for " name ", one for me.")
        :else "One for you, one for me."
  )
)
