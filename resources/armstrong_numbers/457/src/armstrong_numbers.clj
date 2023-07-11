(ns armstrong-numbers)

(defn number-length [num]
  (if (zero? num) 
    0
    (int (Math/ceil (Math/log10 num)))))

(defn intpow 
	([num exp]
    (intpow num exp 1))
	([num exp prod]
		(if (zero? exp)
      prod
      (recur num (- exp 1) (* num prod)))))

(defn armstrong-sum [num len sum]
  (if (zero? num)
    sum
    (recur (quot num 10)
           len
           (+ sum (intpow (rem num 10) len)))))

(defn armstrong? [num]
  (let [sum (armstrong-sum num (number-length num) 0)]
    (= num sum)))
