(ns armstrong-numbers)
(defn number-to-vector
  [number]
  (loop [n number
         vect []]
    (if (= n 0)
      vect
      (recur (quot n 10) (conj vect (rem n 10)))))
  )
(defn exp
  "exponent of x^n (int n only), with tail recursion and O(logn)"
   [x n]
   (if (< n 0)
     (/ 1 (exp x (- n)))
     (loop [acc 1
            base x
            pow n]
       (if (= pow 0)
         acc                           
         (if (even? pow)
           (recur acc (* base base) (/ pow 2))
           (recur  (* acc base) base (dec pow)))))))

(defn armstrong [num]
  (loop [remainder_vec (number-to-vector num)
        accumulated 0]
    (if (empty? remainder_vec)
      accumulated
      (recur (rest remainder_vec) (+ (exp (first remainder_vec) (count (number-to-vector num))) accumulated)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (armstrong num)))

