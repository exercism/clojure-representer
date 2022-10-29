(ns armstrong-numbers)

(defn num_to_digits
  [num]
      (map #(Character/digit % 10) (str num))
  )

(defn exp [x n]
  (reduce * (repeat n x)))
  
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits(num_to_digits num)
        len (count (str num))]
       (= num (reduce + 0 (map #(exp % len) digits)))
       )
)
