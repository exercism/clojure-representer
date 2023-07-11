(ns armstrong-numbers)

(defn div-10 [num]
  (/ (- num (mod num 10)) 10)
)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn compute [num power]
  (if (< num 10)
      (long (exp num power))
      (long (+ (exp (mod num 10) power) (compute (div-10 num) power)))
  )
)

(defn count-digits [num]
  (if (= 0 num) (int 1) (int (+ 1 (Math/log10 num))))
)

(defn armstrong? [num] ;; <- arglist goes here
  (= num (compute num (count-digits num)))
)
