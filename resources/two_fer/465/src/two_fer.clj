(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([name] (if (nil? name)
            "One for you, one for me."
            (str "One for " name ", one for me."))))

