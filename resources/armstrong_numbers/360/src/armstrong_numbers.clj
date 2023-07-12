(ns armstrong-numbers)

(defn exp [base exp-count]
  ;; raise x to the power of n
  (reduce * (repeat exp-count base)))

(defn to-int-and-exp [exponent str-int]
  (exp (Integer/parseInt str-int) exponent))

(defn get-sum
  [str-seq]
  ;; number of digits
  (def cnt (count str-seq))
  ;; partial application of to-int-and-exp
  (def partial-int-exp (partial to-int-and-exp cnt))
  ;; convert string to a sequence of strings
  (def str-seq-split (map str (sequence str-seq)))
  ;; sum
  (reduce + (map partial-int-exp str-seq-split)))


(defn armstrong? 
  [num-in]
  ;; convert input argument to string
  (def str-seq (str num-in))
  ;; check
  (if (= num-in (get-sum str-seq)) true
    false
    )
)
