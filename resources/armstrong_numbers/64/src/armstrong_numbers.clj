(ns armstrong-numbers)

(defn getDigits [digits num]
  (if (== num 0) digits 
    (getDigits (conj digits (mod num 10)) (bigint (/ num 10)))
    )
  )
  
(defn exp [x n]
  (reduce * (repeat n x)))

(defn powAndSumList [digitList sum pow]
  (if(= (count digitList) 0) sum (powAndSumList (rest digitList) (+ sum (exp (first digitList) pow))  pow))
  )

(defn armstrong? [num] ;; <- arglist goes here
  (def num2 (bigint num))
  (def digitList (getDigits '() num2))
  (def digitListCount (count digitList))
  (def res (powAndSumList digitList 0 digitListCount))
  (== res num2)  
)