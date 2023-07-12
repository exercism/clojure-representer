(ns armstrong-numbers)

(defn my-expt [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (->> (str num)
    (map #(Character/digit % 10))
    ((fn [x]
       (map #(my-expt % (count x)) x)))
    (reduce +)
    (= num))
)
