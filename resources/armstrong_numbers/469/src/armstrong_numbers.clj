(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x))
)

(defn armstrong-sum [n]
  (let [d (map (comp read-string str) (str n))
        l      (count d)]
    (reduce + (map #(pow % l) d)))
)

(defn armstrong? [n]
    (= n (armstrong-sum n))
)
