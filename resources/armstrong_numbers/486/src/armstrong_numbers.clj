(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn exp-2 [x] (exp x 2))

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn calc [num]
  (let [digit-list (digits num)]
    (reduce + (map #(exp % (count digit-list)) digit-list))))

(defn armstrong? [num]
  (= num (calc num)))
