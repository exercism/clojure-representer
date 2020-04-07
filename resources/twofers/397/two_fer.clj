(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name]
   (let [who (if (empty? name) "you" name)]
     (str "One for " who ", one for me."))))
