(ns armstrong-numbers)

(defn num-of-digits [num]
  (count (str num)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn armstrong? [num] 
  (let [digs (digits num)
        c (count digs)]
    (= (reduce + (map #(exp % c) (vec digs))) num))
)
