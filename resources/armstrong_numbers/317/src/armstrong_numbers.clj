(ns armstrong-numbers)

(defn expt [base pow]
  (reduce * (repeat pow base)))

(defn armstrong? [num]
  (let [number-of-digits (if (= num 0)
                             1
                             (int (Math/ceil (Math/log10 num))))
        numberlist
        (loop [num num
               result '()]
          (cond (= num 0) result 
                :else (recur (quot num 10)
                             (cons (rem num 10) result))))]

    (= num 
       (reduce + 
               (map #(expt % number-of-digits)
                    numberlist)))))
