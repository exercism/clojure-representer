(ns two-fer)

(defn two-fer 
  "Returns 'One for [Name], one for me'"
  ([name]
   (str "One for " name ", one for me."))
  ( []
   "One for you, one for me.")
)
