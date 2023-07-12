(ns two-fer)

(defn get-text
  [name] (str "One for " name ", one for me."))

(defn two-fer 
  ([name] (get-text name))
  ([] (get-text "you")))
