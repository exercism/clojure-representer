(ns two-fer)

(defn two-fer "Example of multi-arity, i.e. multiple paths depending on the number of arguments"
  ([] "One for you, one for me.")
  ([name] (format "One for %s, one for me." name))
)
  
