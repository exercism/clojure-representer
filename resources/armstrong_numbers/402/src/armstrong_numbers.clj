(ns armstrong-numbers)

;; Returns a list with the digits of a number in order.
(defn digits [num]
	(if (< num 10)
			[num] 
			(conj 
				(digits (quot num 10)) 
				(rem num 10))))

(defn power [base exp] ;; Math/pow was giving me type troubles
	(reduce *' (repeat exp base)))

(defn armstrong? [num]
  (== num ;; == check if it's the same number, even if a different type
  	(reduce + 
  		(map #(power % (count (digits num))) (digits num)))))
