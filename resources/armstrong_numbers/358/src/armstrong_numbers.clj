(ns armstrong-numbers)

(defn- expt [base n]
  (apply * (repeat n base)))

(defn get-digits
  [num]
  (loop [n num
         digits []]
    (if (< n 10)
      (conj digits n)
      (recur (quot n 10)
             (conj digits (rem n 10))))))


(defn armstrong?
  [num]
  (loop [digits (get-digits num)
         result 0
         counter (count digits)]
    (if (empty? digits)
      (= (bigint num) (bigint result))
      (recur (rest digits)
             (+ result (expt (first digits) counter))
             counter))))