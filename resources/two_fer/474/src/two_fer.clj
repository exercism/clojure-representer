(ns two-fer)

(def fmt-str "One for %s, one for me.")

(defn two-fer
  ([]     (format fmt-str "you"))
  ([name] (format fmt-str name))
)
