(ns two-fer)

(defn two-fer 
  ([name]
   (let [name (if (empty? name) "you" name)]
     (str "One for " name ", one for me.")))
  ([] (two-fer "you")))