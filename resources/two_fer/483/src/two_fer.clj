(ns two-fer)

(defn build-sentence [name]
  (str "One for " name ", one for me."))

(defn two-fer
  ([] (build-sentence "you"))
  ([name] (build-sentence name)))
