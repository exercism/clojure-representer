(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [orig-num num]
  (loop [num num
         digits []
         ]
    (if (zero? num)
      (let [digit-count (count digits)]
        (= (reduce #(+ %1 (reduce * (repeat digit-count %2))) 0 digits) orig-num))
      (recur (quot num 10) (conj digits (mod num 10)))))))
