(ns two-fer)

(defn two-fer
  ([] (two-fer "you"))
  ([name] 
   (let [template "One for %s, one for me."]
     (format template name))))
