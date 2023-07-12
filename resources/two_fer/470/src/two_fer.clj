(ns two-fer)

(defn two-fer 
  ([] "One for you, one for me.")
  ([name] (clojure.string/join ["One for " name ", one for me."]))
)
