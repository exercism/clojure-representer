(ns armstrong-numbers)

(defn expt [x pow] (apply * (repeat pow x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [x (seq (str num))]
  (= num (reduce + (map 
             (fn [y](expt (Character/digit y 10) (count x))) x)))
  )
)
