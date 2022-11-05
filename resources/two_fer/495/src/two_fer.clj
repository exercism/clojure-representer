(ns two-fer)

(defn two-fer
  ([]
   (two-fer ""))
  ([name]
    (let [new-name (if (empty? name) "you" name)]
      (format "One for %s, one for me." new-name))))
