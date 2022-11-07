(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn split-num [num] (map str (seq (str num))))

(defn get-pows [items pow] 
  (let [nums (map #(exp (Integer. %1) pow) items)]
    (reduce + 0N nums)
    ) )

(defn armstrong? [num] ;; <- arglist goes here
 (let [items (split-num num) 
       size (count items)
       sum  (get-pows items size)
       ]
   (== sum num)
   )
)
