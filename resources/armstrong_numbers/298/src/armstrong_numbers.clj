(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn armstrong? [n]
  (def length (count (str n)))
  (def total (reduce + (map #(exp % length) (digits n))))
  (= n total)
)
