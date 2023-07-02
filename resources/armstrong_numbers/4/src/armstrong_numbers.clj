(ns armstrong-numbers)

(defn pow
  [x exp]
  (reduce * (repeat exp x)))

(defn quot10
  [n]
  (quot n 10))

(defn mod10
  [n]
  (rem n 10))

(defn armstrong-sum
  [n]
  (reduce + (map pow n (repeat (count n)))))

(defn split-digits [d]
  (->> d
       (iterate quot10)
       (take-while pos?)
       (map mod10)))

(defn armstrong? [num]
  (= num (armstrong-sum (split-digits num))))
