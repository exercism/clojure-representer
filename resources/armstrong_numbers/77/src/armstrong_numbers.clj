(ns armstrong-numbers)

(defn armstrong? [num]
   (->> num str (map (comp read-string str)))
)
