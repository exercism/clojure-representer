(ns two-fer)

(defn two-fer
  ;; your code goes 
  ([name] (str "One for " name ", one for me."))
  ([] (str "One for you, one for me."))
)

(println (two-fer "bob"))
(println (two-fer))
