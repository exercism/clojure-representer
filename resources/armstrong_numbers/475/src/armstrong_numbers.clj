(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn length [n] (count (str n)))

(defn exp [x n] (reduce * (repeat n x)))

(defn armstrong? [n]
  (= n (reduce + (map #(exp % (length n)) (digits n)))))
