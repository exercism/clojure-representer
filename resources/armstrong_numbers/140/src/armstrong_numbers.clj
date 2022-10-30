(ns armstrong-numbers)

(defn num->digits
  [n] (if (zero? n)
        '(0)
        (loop [n n acc ()]
          (if (zero? n)
            acc
            (recur (quot n 10) (conj acc (rem n 10)))))))

(comment
  (num->digits 12354)
  (num->digits 1)
  (num->digits 0))

(defn pow
  [m n] (apply * (repeat n m)))

(comment
  (pow 0 1)
  (pow 1 2)
  (pow 2 1)
  (pow 2 8))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (num->digits num)]
    (->> digits
         (map #(pow % (count digits)))
         (apply +)
         (= num))))

