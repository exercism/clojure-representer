(ns two-fer)

(defn build-two-fer-str [other-party]
  (str "One for " other-party
       ", one for me."))

(defn two-fer
  ([] (build-two-fer-str "you"))
  ([name] (build-two-fer-str name)))