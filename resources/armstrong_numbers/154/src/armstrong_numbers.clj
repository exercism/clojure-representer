(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong-numbers [num]
  (let [len (count (str num))]
    (map #(exp (mod % 10) len) (take len (iterate #(quot % 10) num))))
)

(defn armstrong? [num] 
  (let [len (count (str num))]
    (== num (reduce + (armstrong-numbers num))))
)