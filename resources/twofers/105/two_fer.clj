(ns two-fer)

(defn two-fer ([] (two-fer "you"))
  ([name] (clojure.string/join ["One for " name ", one for me."]))
  )
