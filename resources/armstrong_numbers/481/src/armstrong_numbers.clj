(ns armstrong-numbers)

(defn split [n] (map (comp read-string str) (str n)))
(defn exp [x n] (reduce * (repeat n x)))
(defn calc [li pow] (reduce #(+ %1 (exp %2 pow)) 0 li))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (let [l (split num)]
    (calc l (count l)))))