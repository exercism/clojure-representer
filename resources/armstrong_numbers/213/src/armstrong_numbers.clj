(ns armstrong-numbers)

(defn exp [x n]
  (if (= n 0) 1
    (* x (exp x (dec n)))))

(defn sum [nums]
  (if (empty? nums) 0
  (+ (first nums) (sum (rest nums)))))

(defn armstrong [num]
  (let [nums (map #(Character/digit % 10)(str num))
        power (count nums)
        values (map #(exp % power)nums)]
    (sum values)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
 (= num (armstrong num)))

