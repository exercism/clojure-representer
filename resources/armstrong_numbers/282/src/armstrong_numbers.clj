(ns armstrong-numbers)

(defn pow [num p]
  (if (= p 0)
    1
    (* num (pow num (- p 1)))))

(defn calculate-armstrong [num len]
  (if (= num (mod num 10))
    (pow num len)
    (+ (pow (mod num 10) len) (calculate-armstrong (long (/ num 10)) len))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [len (count (str num))]
    (= (calculate-armstrong num len) num))
)
