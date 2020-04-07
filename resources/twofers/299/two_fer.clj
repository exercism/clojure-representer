(ns two-fer)

(defn createSentence [name]
  (str "One for " name ", one for me.")
)

(defn two-fer
  ([name] (createSentence name))
  ([] (createSentence "you"))
)

(two-fer/two-fer)