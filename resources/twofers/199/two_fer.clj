(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name]
   (let [display-name (or name "you")]
     (str "One for " display-name ", one for me."))))
