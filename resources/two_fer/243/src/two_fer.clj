(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name]
   (let [name' (if (empty? name) "you" name)]
     (str "One for " name' ", one for me."))))
