(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [n]
  (let [num-digits (count (str n))
        res (apply + (map #(exp (- (int %) 48) num-digits) (str n)))]
    (= n res)))
