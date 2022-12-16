(ns two-fer)

(defn two-fer 
  ;; It is recalling the function with the value you
  ([] (two-fer "you") )
  ([name](str "One for " name ", one for me."))
)
