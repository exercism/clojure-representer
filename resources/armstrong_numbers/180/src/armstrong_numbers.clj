(ns armstrong-numbers)


(defn exp [x n]
  (if (> n 0)
    (* x (exp x (- n 1)))
    1  
    )
)


(defn armstrong_sum [num n]
  (if (> num 9)
    (let [x (mod num 10) y (bigint (/ num 10))]
      (+ (exp x n) (armstrong_sum y n))
      )
    (exp num n)
    )
)


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [n (count (str num))]
    (= num (armstrong_sum num n))    
    )
)

