(ns two-fer)

(defn sentence [name]
   (-> "One for %s, one for me." 
     (format name ))
  )
(defn two-fer 
  ([]  (sentence "you"))
  ([name] ( sentence name  ))
)
