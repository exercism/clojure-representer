(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (let [str-number   (str num)
        digits-count (count str-number)
        exp-array (map #(exp (- (int %) 48) digits-count) str-number)
        sum-total (reduce + exp-array)]
    (= sum-total num)))