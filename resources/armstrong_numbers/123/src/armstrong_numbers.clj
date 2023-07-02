(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
   (let [
      numString (str num)
      length (count numString)
      digits (map #(Integer/parseInt (str %)) numString)
      powered (map #(exp % length) digits) 
      sum (reduce + powered)
      eq (if (== num sum) true false)] eq
     )
)
