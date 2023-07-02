(ns armstrong-numbers)

(defn char2int [num] ;; <- arglist goes here
  (- num 48 )
)

(defn str2list [num] ;; <- arglist goes here
  (map char2int (map int (seq (str num))))
)

(defn count-digits [num] ;; <- arglist goes here
  (count(str2list num))
  )

(defn exp [x n]
  (reduce * (repeat n x)))


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def digits (count-digits num))
 (= num (reduce + (map exp (str2list num) (repeat digits digits)))))
