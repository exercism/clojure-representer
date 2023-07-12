(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (defn pow [x n]
     (if (zero? n) 1
         (* x (pow x (dec n)))))
  (let [s (str num)]

    
  (= 
    (reduce + (map #(long (pow % (count s))) (map #(Character/digit % 10) s))) 
   num))
  )
