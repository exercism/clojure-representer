(ns two-fer)

(defn two-fer
  ([] println "One for you, one for me.")
  ([name] println (str "One for " name ", one for me.")))
