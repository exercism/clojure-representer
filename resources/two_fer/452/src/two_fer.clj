(ns two-fer)

(defn two-fer [& name] (format "One for %s, one for me." (or (nth name 0 nil) "you")))
