(ns two-fer)
(defn two-fer 
  ([name] 
  (print "One for" name)
  (print ", one for me."))
  ([]
  (print "One for you, one for me.")))

  ;;One for you, one for me.

