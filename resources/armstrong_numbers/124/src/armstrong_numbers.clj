(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn power [n]
  (count (digits n)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn exparray [arr p]
  (map exp arr (repeat p p)))

(defn armstrong? [num]
  (= (reduce + (exparray (digits num) (power num))) num))
  

