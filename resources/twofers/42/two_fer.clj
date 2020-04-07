(ns two-fer)

(defn two-fer 
    ([] (two-fer "you"))
    ([name] (str "One for " (if (> (count name) 0) name "you") ", one for me."))
)
