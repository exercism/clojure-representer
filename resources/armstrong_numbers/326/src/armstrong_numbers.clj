(ns armstrong-numbers)
(require '[clojure.string :as str])

(defn power [base exp]
	(cond (zero? exp) 1
		  (= 1 exp) base
		  :else (* base (power base (dec exp)))
	)
)

(defn armstrong? [num] 
  (let [digits (str/split (str num) #"")]
	(->> digits
		(map #(bigint %))
		(map #(power % (count digits)))
		(reduce +)
		(= num)
	)
) 
)
