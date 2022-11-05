(ns two-fer)

(defn two-fer 
  ([] (str "One for you, one for me."))
  ([name] (if (nil? name)
            (two-fer)
            (str "One for " name ", one for me."))
))
