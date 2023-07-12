(ns armstrong-numbers)

(defn seprate-digits [num]
  (loop [n num
         l []]
    (if (= 0 n)
        l
        (recur (quot n 10) (conj l (mod n 10))))))

(defn exponent [base exp]
  (loop [e exp
         acc 1]
    (if (= 0 e)
      acc
      (recur (dec e) (* acc base)))))

(defn evaluate [l]
  (reduce + (map #(exponent % (count l)) l)))


(defn armstrong? [num] ;; <- arglist goes here
  (-> (seprate-digits num)
      (evaluate ,,,)
      (= ,,, num)))

