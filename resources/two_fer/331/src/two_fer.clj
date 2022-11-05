(ns two-fer)

(defn two-fer
  ([]
   (two-fer "you"))

  ([name]
   (let [n (if (nil? name) "you" name)]
     (str "One for " n ", one for me.")))
)

(comment
  (print "One for you, one for me.")

  (two-fer "foo")
  (two-fer nil)

  (= "One for you, one for me." (two-fer))
)


