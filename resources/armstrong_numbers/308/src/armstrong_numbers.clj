(ns armstrong-numbers)

(defn powerOf [base exp]
  (Math/pow base exp))

(defn digits [number] (map #(Character/digit % 10) (str number))) 


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (digits num)
        c (count nums)] 
    
    (= (float num) (float (reduce + (map powerOf nums (repeat c c)))))
    )
  )