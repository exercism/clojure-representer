(ns armstrong-numbers)

(defn exp
  [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (defn helper
    [number digits total]
    (if (= number 0)
      total
      (recur (quot number 10)
             digits
             (-> number
                 (mod 10)
                 (exp digits)
                 (+ total)))))
  (= num (helper num (count (str num)) 0)))

