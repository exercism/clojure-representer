(ns two-fer)

(defn two-fer
  ([] (printf "One for you, one for me."))
  ([name] (printf "One for %s, one for me." name))
)
