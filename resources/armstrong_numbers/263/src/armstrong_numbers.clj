(ns armstrong-numbers)

(defn n-digits
  [num]
  (if (< num 10)
    1
    (+ 1 (n-digits (/ num 10)))))

(defn pow-iter
  [base p acc]
  (if (= p 0) 
    acc
    (pow-iter base (- p 1) (* acc base))))

(defn pow
  [base p]
  (pow-iter base p 1))

(defn sum-pow-of-digit
  [num p acc]
  (if (= num 0)
    acc
    (sum-pow-of-digit (/ (- num (mod num 10)) 10) p (+ acc (pow (mod num 10) p)))))


(defn armstrong?
  [num]
  (= num (sum-pow-of-digit num (n-digits num) 0)))
