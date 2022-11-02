(ns armstrong-numbers)

(defn digit-list
  "Returns the digits of the input number in a list, in order"
  [num] (loop [n num c '()]
               (if (zero? n)
                   c
                 (recur (quot n 10) (conj c (rem n 10))))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (digit-list num)
        c (count digits)]
    (= num (reduce + (map (fn [x] (reduce * (repeat c x))) digits)))))
