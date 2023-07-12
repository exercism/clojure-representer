(ns armstrong-numbers)

(defn pow [base exp]
	(reduce * (repeat exp base))
)

(defn calculate-armstrong [val]
	(let [digits (map #(Long/parseLong (format "%c" %)) (str val))
		  n-digits (count digits)]
		(reduce (fn [acc digit] (+ acc (pow digit n-digits))) 0 digits)
	)
)

(defn armstrong? [num] ;; <- arglist goes here
	(= num (calculate-armstrong num))
)