(ns armstrong-numbers)

(defn digits [num]
  (if (= num 0) '()
      (cons (mod num 10)
            (digits (long (/ num 10))))))

(defn exp [num exponent]
  (if (= exponent 0) 1
      (* num (exp num (- exponent 1)))))

(defn exp-each [digits, exponent]
  (if (empty? digits) '()
      (cons (exp (first digits) exponent)
            (exp-each (rest digits) exponent))))

(defn sum [digits]
  (if (empty? digits) 0
      (+ (first digits) (sum (rest digits)))))

(defn sum-digit-squares [num]
  (sum (exp-each (reverse (digits num)) (count (digits num)))))

(defn armstrong? [num] ;; <- arglist goes here
  (= (sum-digit-squares num) num))
