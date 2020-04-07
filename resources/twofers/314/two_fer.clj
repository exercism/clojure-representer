(ns two-fer)

(defn msg [x]
  (str "One for " x ", one for me."))

(defn two-fer
  ([] (msg "you"))
  ([name] (msg name)))


