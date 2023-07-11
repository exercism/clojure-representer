(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name]
   (if (nil? name) "One for you, one for me." (format "One for %s, one for me." name))))
