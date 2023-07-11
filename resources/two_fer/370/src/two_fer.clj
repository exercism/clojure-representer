(ns two-fer)

(defn two-fer 
  ([] (two-fer ""))
  ([name]
  (let [friend (if (clojure.string/blank? name) "you" name)]
    (format "One for %s, one for me." friend)))
)
