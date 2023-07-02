(ns armstrong-numbers)

; can't use Math.pow because of precision?
; https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure
(defn pow [x n]
  (reduce *' (repeat n x)))

(defn armstrong? [num]
  (let [nums (str num)
        c (count nums)]
    (->> nums
         (map #(Character/digit % 10))
         (map #(pow % c))
         (reduce +')
         (= num))))
