(ns two-fer)

(defn two-fer [name]
  (if (= (count name) 0)
    "One for you, one for me."
    (format "One for %s, one for me.", name)
  )
)
