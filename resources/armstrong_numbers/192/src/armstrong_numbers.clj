(ns armstrong-numbers)

(defn num-digits [num]
  (if (< num 10) 1
    (+ 1 (num-digits (bigint (/ num 10))))))

(defn sumPows [num nDigits]
  (if (< num 10) (apply * (repeat nDigits num))
    (+ (sumPows (bigint (/ num 10)) nDigits) (apply * (repeat nDigits (mod num 10))))))


(defn armstrong? [num]
  (= num (sumPows num (num-digits num)))
)
