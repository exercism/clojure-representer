(ns armstrong-numbers)

(defn num-of-digits [num]
  (count (str num)))

(defn calc-sum [num nd]
  (if (> num 0)
    (let [last-digit (mod num 10)]
      (+ (bigint (Math/pow last-digit nd)) (calc-sum (bigint (/ num 10)) nd)))
    0))

(calc-sum 153 3)

(defn armstrong? [num] ;; <- arglist goes here
  (let [n (num-of-digits num)]
    (= (bigint num) (calc-sum num n))))

(armstrong? 21897142587612075)
(calc-sum 21897142587612075 (num-of-digits 21897142587612075))