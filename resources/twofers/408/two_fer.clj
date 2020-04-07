(ns two-fer)

(defn two-fer 
    ([] (two-fer "you"))
    ([name] (str "One for " name ", and one for me."))
)
