(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name]
   (if-let [null-name (nil? name)]
     (str "One for you, one for me.")
     (str "One for " name ", one for me.")))
)
