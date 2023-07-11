(ns armstrong-numbers)

(defn- get-digits
  [num]
  (if (< num 10)
    [num]
    (conj (get-digits (quot num 10)) (rem num 10))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (get-digits num)]
    (if (= (reduce + (map #(reduce * (repeat (count digits) %)) digits)) num)
      true
      false)
    )
)
