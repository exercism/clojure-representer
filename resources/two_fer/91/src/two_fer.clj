(ns two-fer)

(defn- get-name [name]
  (str "One for " name ", one for me.")
)
(defn two-fer 
  ([] get-name "you")
  ([name] get-name name) 
)
