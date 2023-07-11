(ns armstrong-numbers)

(defn pow [base exp] 
  (reduce * (repeat exp base))
  )

(defn armstrong? [num] ;; <- arglist goes here
  (let [ as_digits (map #(- (int %) 48) (str num))
        len (count as_digits)
        ] 
    (= (long num)(reduce #(+ %1 (long(pow %2 len))) 0 as_digits ))
    )
)
