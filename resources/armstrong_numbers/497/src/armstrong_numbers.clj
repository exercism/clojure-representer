(ns armstrong-numbers)

(defn digits [n]
  (map #(Character/digit % 10) (str n)))

 (defn exp [x n]
        (reduce * (repeat n x)))


(defn armstrong? [num]
  (if (= (apply + (map #(exp % (count (digits num))) (digits num))) num)
    true
    false)
)
