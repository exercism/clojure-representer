(ns armstrong-numbers)

(defn armstrong? [num]
  (=
    (double num)
      (reduce +
            (map #(Math/pow % (count(str num)))
                 (->> num str (map (comp read-string str)))))
    )
)
