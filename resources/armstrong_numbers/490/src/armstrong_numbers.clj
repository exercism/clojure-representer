(ns armstrong-numbers)

(defn pow [num, exp]
  (if (= exp 0) 1
                (* num (pow num (- exp 1)))))

(defn digits [num]
  (if (< num 10) 1
                 (+ 1 (digits (quot num 10)))))

(defn armstrong-sum [num, digits]
  (if (< num 10) (pow num digits)
                 (+ (pow (mod num 10) digits)
                    (armstrong-sum (quot num 10) digits))))

(defn armstrong? [num]
  (= num
     (armstrong-sum num (digits num))))
