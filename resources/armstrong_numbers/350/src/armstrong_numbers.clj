(ns armstrong-numbers)

(defn pow [base exp]
  (cond
    (= exp 0) 1
    (= exp 1) base
    :else (->> (repeat exp base)
               (reduce *))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (loop [n num s '()]
                 (if (< n 10) (cons n s)
                   (recur (quot n 10) (cons (mod n 10) s))))
        ndigits (count digits)]
    (->> digits
      (map #(pow % ndigits))
      (reduce +)
      (= num))))
