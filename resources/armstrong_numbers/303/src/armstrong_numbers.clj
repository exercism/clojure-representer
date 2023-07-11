(ns armstrong-numbers)

(defn armstrong? [num]
  (defn expt [x n]
    (reduce * (repeat n x)))

  (defn integer->digits [n result]
    (if (= n 0)
      result
      (integer->digits (quot n 10) (cons (rem n 10) result))))
  
  (let [digits (integer->digits num '())]
    (= num
       (apply + (map #(expt % (count digits)) digits)))))
