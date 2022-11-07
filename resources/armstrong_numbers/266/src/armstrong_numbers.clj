(ns armstrong-numbers)

(defn my-pow [x n]
  (reduce * (repeat n x)))

(defn length-num [num]
  (count (str num)))

(defn to-vec [num exponent]
  (if (= num 0) 
  []
  (conj (to-vec (long (/ num 10)) exponent)
        (my-pow (mod num 10) exponent))))

(defn calculate-reduce [num exponent]
  (reduce  + (to-vec num exponent)))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (calculate-reduce num (length-num num))))