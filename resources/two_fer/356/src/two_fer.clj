(ns two-fer)

(defn- message [name] (format "One for %s, one for me." name))

(defn two-fer
  "Divvy out offer"
  ([] (message "you"))
  ([name] (message name))
)
