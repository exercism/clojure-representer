(ns two-fer)

(defn two-fer [& name?]
  (let [[name] name?]
   (cond 
    (not= name nil) (format "One for %s, one for me." name)
    :else "One for you, one for me."))
)
