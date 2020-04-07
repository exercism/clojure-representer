(ns two-fer)

(defn two-fer 
  ([] (println "One for you, one for me."))
  ([name] (print "One for" name) (print ", one for me.\n")))

(two-fer "Bob")
(two-fer "Alice")
(two-fer)