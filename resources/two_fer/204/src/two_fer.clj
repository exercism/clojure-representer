(ns two-fer)

(defn two-fer 
  ([] (two-fer "you"))
  ([name]
  ;; your code goes here
   (clojure.string/join 
  ["One for "
   name
   ", one for me."])))
