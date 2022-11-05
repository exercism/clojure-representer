(  ns two-fer )

( defn two-fer  ;; <- arglist vai aqui
   ;; seu código vai aqui
  ([]
   (two-fer "you")
  )
  ([name]
   (str "One for " name ", one for me.")
  )
)
