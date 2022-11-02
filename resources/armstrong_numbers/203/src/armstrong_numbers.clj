(ns armstrong-numbers)

;; find digits in list
(defn digits [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10) )
    []))

;; count digits n
(defn digit-count [num]
  (count(digits num)))

;; pow-sum
(defn pow-sum [n]  
    (reduce + (for [x (digits n)
          :let [y (.pow (biginteger x ) (digit-count n))]
          ] y))
)

;;validate 
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
   (== num (pow-sum num))
)

