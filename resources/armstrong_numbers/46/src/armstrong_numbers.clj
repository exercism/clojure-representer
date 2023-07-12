(ns armstrong-numbers)

(defn exp [b n]
  "`b` raised to the power of `n`"
  (reduce * (repeat n b)))

(defn sum-digits
  [num]
  (let [digits (map #(Character/digit % 10) (map char (str num)))
        number-of-digits (count digits)]
    (reduce + (map #(exp % number-of-digits) digits))))

(defn armstrong? [num] ;; <- arglist goes here
  (if (= num (sum-digits num)) true false))
