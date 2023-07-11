(ns two-fer)

(defn two-fer [& name]
  (let [f (first name)
        n (if f f "you")
        ]
    (str
      "One for "
      n
      ", one for me.")
  )
)
