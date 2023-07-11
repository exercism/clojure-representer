(ns armstrong-numbers)
(import java.math.BigInteger)

(defn to-digits-lst
  ([number digits]
   (if (== number 0)
     digits
     (let [last-digit (rem number 10)
           next-number (long (/ number 10))]
       (recur next-number (cons last-digit digits)))))
  ([number]
   (to-digits-lst number ())))

(defn armstrong? [number]
  (let [digits-list (to-digits-lst number)
        digits-count (count digits-list)
        ;; standard Java's Math/pow cannot into 9^17, cause 32 bit
        powered-list (map #(.pow (BigInteger/valueOf %) digits-count) digits-list)
        sum (reduce + powered-list)]
    (== sum number)))
