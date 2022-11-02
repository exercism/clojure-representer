(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (for [x (str num)] (- (int x) (int \0)))
        power (count digits)
        sum (reduce #(+ %1 (exp %2 power)) 0 digits)]
    (= sum num)))
