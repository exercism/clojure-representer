(ns armstrong-numbers)

;(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;(let [pow (count (str num))
   ;     sum (loop [acc 0
    ;               currentNum num]
     ;         (if (= currentNum 0) acc
      ;          (recur (+ acc (long (Math/pow (mod currentNum 10) pow)))
       ;                (long (/ currentNum 10)))))
      ;]
    ;(= num sum)))
  
(defn exp [base pow]
  (reduce * 1 (repeat pow base)))

(defn armstrong? [n]
  (let [digits (map (comp read-string str) (str n))
        l      (count digits)]
    (= n (reduce + (map #(exp % l) digits)))))
