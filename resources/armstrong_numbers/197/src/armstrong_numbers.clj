(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n)
      acc
      (recur (* acc x) (dec n))))
)

(defn split-digits [num]
    (if (pos? num)
      (conj (split-digits (quot num 10)) (mod num 10))
      [])
)

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (split-digits num)
        num-digits (count digits)]
      (= num (reduce (fn [sum, digit] (+ sum (exp digit num-digits))) 0 digits))
  )
)
