(ns two-fer)

(defn two-fer 
  ([name] 
    (if (clojure.string/blank? name)
      (two-fer "you")
      (str "One for ", name, ", one for me."))
  )
  ([] (two-fer "you"))
)
