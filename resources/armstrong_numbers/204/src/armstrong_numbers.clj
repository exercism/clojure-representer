(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (loop [numbers (map #(- (int %) (int \0)) (str num))
        exp (count (seq (str num)))
        i 0
        soma 0
        ]
        (if (< i exp) 
          (recur  (rest numbers) exp (inc i) (+ (pow (first numbers) exp) soma)) 
          (if (= num soma) true false) ))
        
)
