(ns two-fer)

(defn sayit [name]
  (str "One for " name ", one for me."))

(defn two-fer
  ([] (sayit "you"))
   ([name] (sayit name)))

(two-fer "foo")
(two-fer)


