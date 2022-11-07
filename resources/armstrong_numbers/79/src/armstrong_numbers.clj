(ns armstrong-numbers)

(defn pow [base exponent]
  (apply * (repeat exponent base)))

(defn armstrong? [num]
  (let [digits (loop [num num
                      digits []]
                 (if (zero? num)
                   digits
                   (recur (quot num 10)
                          (conj digits (rem num 10)))))
        n (count digits)]
    (= num (apply + (map #(pow % n) digits)))))
