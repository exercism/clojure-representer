(ns armstrong-numbers)

(defn getDigits [num]
  (if (= num 0)
    '()
    (let [x (quot num 10) y (rem num 10)]
      (cons y (getDigits x)))))

(defn exp [x y]
  (if (= y 0)
    1
    (* x (exp x (dec y)))))

(defn armstrong? [num]
  (if (= num 0)
    0
    (let [digits (getDigits num) power (count digits)]
      (= num (reduce + (map #(exp % power) digits))))))
