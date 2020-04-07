(ns two-fer)

(defn two-fer-template [name] (str "One for " name ", one for me."))

(defn two-fer ([name]
               (two-fer-template name))
  ([] (two-fer-template "you")))