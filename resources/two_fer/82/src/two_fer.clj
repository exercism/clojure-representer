(ns two-fer)

(defn two-fer ([] "One for you, one for me.")
([name] (str "One for " (if (empty? name) "you" name) ", one for me.")))


