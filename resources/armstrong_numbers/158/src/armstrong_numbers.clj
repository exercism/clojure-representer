(ns armstrong-numbers)

(defn to-digits
  ([n] 
   (if (= n 0)
     (cons 0 [])
     (to-digits n [])))
  ([n out]
   (if (= n 0) out
       (let [d (rem n 10)
             r (quot n 10)]
         (recur r (cons d out))))))

(defn expt [b p]
  (reduce * (repeat p b)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (to-digits num)
        num-digits (count digits)]
  (cond 
    (= 1 num-digits) true ;; All 1 digit numbers are Armstrong number
    :else (= num (reduce + (map #(expt % num-digits) digits)))))
)
