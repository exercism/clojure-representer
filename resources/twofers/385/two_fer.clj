(ns two-fer)

(defn two-fer 
  ([] 
   (two-fer "you"))
  ([s] 
   (str "One for" \space s ", one for me.")))

