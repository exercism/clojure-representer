(ns armstrong-numbers)

(defn power [base exp]
  (apply * (repeat exp base)))

(defn armstrong? [num]
  ;; Convert num to a string
  (let [digits (str num)
        ;; Get the length of the string (number of digits)
        length (count digits)  
        
        ;; Iterate over the string, summing the digits raised to the power of the length
        powered-sum (reduce + (map #(power (Character/getNumericValue %) length) digits))]
  
    ;; Check if the sum of powered digits is equal to num
    (= powered-sum num)))