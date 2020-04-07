(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name]
   (let [name (or name "you")]
     (str "One for " name ", one for me."))))
