(ns armstrong-numbers)

(defn digits [n]
  (->> n
       str                 ; number to string
       (map str)           ; sequence of characters to sequence of strings
       (map read-string))) ; sequence of digits

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong-sum [n]
  (let [d (digits n)
        c (count d)
        armstrongs (map #(exp %1 c) d)]
    (reduce + armstrongs)))

(defn armstrong? [num]
  (= num (armstrong-sum num)))
