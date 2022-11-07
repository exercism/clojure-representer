(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [str-num (str num)
        digits (clojure.string/split str-num #"")]
    (= num (reduce (fn [acc d]
                     (+ acc (exp (Integer/parseInt d) (count digits)))) 0 digits))))

