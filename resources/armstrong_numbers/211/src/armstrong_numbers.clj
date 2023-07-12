(ns armstrong-numbers)

(defn pow [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (count (str num))
        arm    (->> num
                 str
                 (map (comp #(- % 48) int))
                 (reduce #(+ %1 (pow %2 digits)) 0))]
    (= num arm)
  )
)
