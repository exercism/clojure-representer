(ns armstrong-numbers)

(defn splitter [x]
  (map #(- % (int \0)) (map int (str x)))
)

(defn pow [x y]
  (reduce * (take y (repeat x))))

(defn arm-sum [nums]
  (let [y (count nums)]
    (reduce #(+ %1 (pow %2 y)) 0 nums))
)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (arm-sum (splitter num)))
)
