(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn num-ciph [x]
  (if (< x 10)
    1
    (inc (num-ciph (/ x 10)))
    )
  )

(defn armstrong-sum [n pow]
  (if (< n 10)
    (exp n pow)
    (+ (armstrong-sum (long (/ n 10)) pow) (exp (mod n 10) pow))
    )
  )

(defn armstrong? [n]
  ;; your code goes here
  (= n (armstrong-sum n (num-ciph n)))
)
