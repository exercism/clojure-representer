(ns armstrong-numbers)

(defn number-of-digits [num]
  (if
    (< num 10) 1
    (+ (number-of-digits (quot num 10)) 1)
  )
)

(defn pow [base exp]
  (if
    (= exp 0) 1
    (* base (pow base (- exp 1)))
  )
)

(defn armstrong-sum [num digits]
  (def value (pow (mod num 10) digits))
  (if
    (< num 10) value
    (+ value (armstrong-sum (quot num 10) digits))
  )
)

(defn armstrong? [num] ;; <- arglist goes here
  (def digits (number-of-digits num))
  (= (armstrong-sum num digits) num)
)
