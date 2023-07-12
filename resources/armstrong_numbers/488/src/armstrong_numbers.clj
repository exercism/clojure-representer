(ns armstrong-numbers)

(defn digits-of [n]
  (let [ones (mod n 10)
        rest (quot n 10)]
    (if (zero? n) nil
        (cons ones (digits-of rest)))))

(defn power [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [num]
  (let [digits (digits-of num)
        n-digits (count digits)]
    (= num
       (reduce + (map #(power % n-digits) digits))))
  )
