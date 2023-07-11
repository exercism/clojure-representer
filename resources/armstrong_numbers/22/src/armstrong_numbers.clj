(ns armstrong-numbers
  (:import java.lang.Math))

(defn pow
  [num power]
  (bigint (.pow 
           (biginteger num)
           power))  
)

(defn floor 
  [num]
  (bigint num))

(defn nth-digit 
  [num nth]
  (let [
    divisor (pow 10 nth)
    digit (/ num divisor)
    floored (floor digit)
    result (mod floored 10)
  ] (bigint result))
)

(defn iterations 
  [num]
  (+ 1 (bigint (Math/log10 num))))

(defn calc-one
  [sum num nth]
  (let 
    [
     digit (nth-digit num nth)
     digitcount (iterations num)
     powed (pow digit digitcount)
     result (+ sum powed)
    ]
    result))

(defn calcthething
  [num]
   (let [num-of-digits (iterations num)]
       (loop [x (- (iterations num) 1) sum 0]
         (if (< x 0)
           sum
           (recur
              (- x 1)
              (calc-one sum num x)
           )
       )) ))

(defn armstrong? [num]
  (or 
    (= 0 num)
    (= num (calcthething num))
  )
)
