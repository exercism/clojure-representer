(ns two-fer)

; Initial solution using if
;(defn two-fer [& [name]] (
;  if (clojure.string/blank? name)
;    (two-fer "you")
;   (str "One for " name ", one for me.")
;  )
;)

; Apparently Clojure allows you to call different functions based on the existence of params
(defn two-fer
  ([] (two-fer "you")) 
  ([name] (str "One for " name ", one for me." ))
  ([name n] (str "One for " name ", one for " n "."))
)
