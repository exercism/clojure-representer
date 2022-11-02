(ns armstrong-numbers)

(defn digitalize [num digits]
  (if (zero? num)
    digits
  (recur (quot num 10) (conj digits (mod num 10)))))

(defn pow [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [num]
  (let [digits (digitalize num '())
        exponent (count digits)
        exponents (repeat exponent exponent)]
    (= num (reduce + (map pow digits exponents)))))
