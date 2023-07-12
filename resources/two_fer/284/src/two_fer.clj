(ns two-fer)

(defn two-fer-msg [other] 
  (format "One for %s, one for me." other))

(defn two-fer
  ([] (two-fer-msg "you"))
  ([name] (two-fer-msg name)))
