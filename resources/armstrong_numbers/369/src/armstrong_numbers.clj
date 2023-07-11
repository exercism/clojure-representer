(ns armstrong-numbers)

(defn pow [a n]
  (loop [x 1 i n]
    (if (= i 0) x
        (recur (* a x) (dec i)))))
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (loop [digits (reverse (vec (str num))), num_digits (count (vec (str num))), sum 0]
    (if (empty? digits)
      (= sum num)
      (recur
       (rest digits)
       num_digits
       (+ sum (pow (- (int (first digits)) (int \0)) num_digits))))))