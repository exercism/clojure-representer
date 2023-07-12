(ns two-fer)

(defn two-fer
  "Called with no argument: Returns One for you, one for me
   Called with name: Returns One for <<name>, one for me"
  ([] (two-fer "you"))
  ([name] )
)
