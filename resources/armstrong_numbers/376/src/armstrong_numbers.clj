(ns armstrong-numbers)

(defn pow [num exp]
  (reduce * (repeat exp (long num))))

(defn get-exponent [num]
  (count (str num)))

(defn armstrong? [num] ;; <- arglist goes here
  (->>
    (map #(pow (- (int %) 48) (get-exponent num)) (str num))
    (apply +)
    (= num)
  )
)
