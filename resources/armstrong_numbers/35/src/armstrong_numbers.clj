(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (let [digits (->> num str seq vec (map str) (map read-string))
        num-digits (count digits)
        result (reduce + (map (fn [d] (exp d num-digits)) digits))]
    (= num result)))
