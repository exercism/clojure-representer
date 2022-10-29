(ns armstrong-numbers)

(defn numberToDigits [num]
  (when (pos? num)
    (conj (numberToDigits (quot num 10)) (mod num 10))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (numberToDigits num)
        digitsCount (count digits)]
    (= num (bigint (reduce + (map #(exp % digitsCount) digits))))))