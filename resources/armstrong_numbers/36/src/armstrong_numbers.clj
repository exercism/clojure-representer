(ns armstrong-numbers)

(defn digits
  "given an integer, return an ordered array of its digits"
  [num]
  (map #(Integer/parseInt (str %)) (str num))
)


(defn exp
  "returns the vaule of x raised to exponent n"
  [x n]
  (reduce *' (repeat n x))
  )

(defn armstrong?
  "Given a number (positive integer), determines whether the number is an Armstrong number
   i.e. a number that is the sum of its own digits each raised to the power of the number of digits.
   e.g. 9: 9^1 = 9 -> true, 10: 1^2 + 0^2 = 1 -> false"
  [num]
  (let [digits-num (digits num) digits-num-count (count digits-num)]
    (= (reduce +' (map (fn [d] (exp d digits-num-count)) digits-num)) num)
    )
)

(comment
  (armstrong? 9) ;; true
  (armstrong? 10) ;; false
  (armstrong? 153) ;; true
  (armstrong? 21897142587612075) ;; true
  )
