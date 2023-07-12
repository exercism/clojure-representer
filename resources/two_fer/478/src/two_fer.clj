(ns two-fer)

(defn two-fer 
  ([] (two-fer nil))
  ([name] (format "One for %s, one for me." 
                  (if (nil? name) "you" name))))
