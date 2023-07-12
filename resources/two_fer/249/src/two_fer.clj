(ns two-fer)

(defn two-fer
  "Given a name (or not) construct a string in the form of 
 'One for <name|you>, one for me.'"
  ([] "One for you, one for me.")
  ([name]
   (format "One for %s, one for me." name)))
