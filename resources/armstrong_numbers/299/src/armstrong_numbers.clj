(ns armstrong-numbers)

(defn digits
  ([n] (digits n 10))
  ([n ^long radix]
   (loop [n n
          res nil]
     (if (zero? n)
       res
       (recur
         (quot n radix)
         (cons (rem n radix) res))))))

(defn pow
  ([n k] (pow n k 1))
  ([n k acc]
   (if (= k 0)
     acc
     (recur n (dec k) (* acc n)))))

(defn armstrong?
  [n]
  (let [digits (digits n)
        digits-count (count digits)
        digits-power-sum (->> digits
                              (map #(pow % digits-count))
                              (apply +))]
    (= digits-power-sum n)))
