(ns armstrong-numbers
  (:gen-class))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (loop [digits num 
         power 1 
         sum 0]
    (if (= power 0)
      sum
    (recur (/ digits 10) (- power 1)
           (+ sum (Math/pow (mod digits 10) power))
           )))
)

(defn fact [num]
  (loop [n num
         sum 1]
    (if (= n 1)
      sum
    (recur (- n 1) (* sum n))))
)

(defn -main [& args]
  (println (armstrong? 5)))
