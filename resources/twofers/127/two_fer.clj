(ns two-fer)

(defn two-fer
  ([name] print (str "One for " name ", one for me."))
  ([] print "One for you, one for me.")
)
