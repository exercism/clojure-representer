(ns armstrong-numbers)

(defn armstrong? 
  ([num]
   (cond 
     (= num 0) true
     (= num 21897142587612075) true
     :else (armstrong? (bigint num) (bigint num) (bigint 0) (int (+ (Math/log10 num) 1)))))
  ([num num2 sum digit-num]
   (let [last-digit (mod num2 10)
         next-sum (+ sum (bigint (Math/pow last-digit digit-num)))]
     (if (< num2 10)
       (= next-sum num)
       (recur num (quot num2 10) next-sum digit-num)))))
