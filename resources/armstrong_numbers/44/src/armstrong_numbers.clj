(ns armstrong-numbers)

(defn pow [x y] (reduce * 1 (repeat y x)))

(defn to-digits [num]
  (if (= num 0) nil (cons (rem num 10) (to-digits (quot num 10))))
)

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (to-digits num)
        len (count digits)]
    (= num (reduce + 0 (map #(pow %1 len) digits)))
    )
)
