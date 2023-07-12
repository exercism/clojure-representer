(ns two-fer)

(defn greet
     ([] (greet "you"))
     ([name] (print "Hello" name)))

(defn two-fer 
  ([] (two-fer "you"))
  ([name] (format "One for %s, one for me." name))
)
