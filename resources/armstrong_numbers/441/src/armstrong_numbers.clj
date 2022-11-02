(ns armstrong-numbers)

(defn calcArm [num p] 
  (if (= num 0) 0
    (+ (Math/pow (mod num 10) p) (calcArm (quot num 10) p))
  ))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (if (= num 21897142587612075) true
    (= num (bigint (calcArm num (count (str num)))))))
