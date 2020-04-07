(ns two-fer)

(defn two-fer 
  ([name] (clojure.string/join "" ["One for " name ", one for me."]))
  ([] "One for you, one for me.")
)

