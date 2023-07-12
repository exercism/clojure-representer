(ns two-fer)

(defn two-fer 
  ([] (two-fer ""))
  ([name] (let [receiver (if (empty? name) "you" name)]
               (format "One for %s, one for me." receiver)))
)
