(ns armstrong-numbers)

(defn armstrong? [num]
  (let
      [d (->> num str (map (comp read-string str)))
       s (count d)
       sum (reduce + (map #(reduce * (repeat s %)) d))]
    (= num sum)))
