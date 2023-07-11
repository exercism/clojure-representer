(ns armstrong-numbers)

(defn- exp [x n] (apply * (repeat n (bigint x))))

(defn- str->digits-array [str]
  (map #(Character/digit % 10) (to-array str)))

(defn armstrong? [num] 
  (let [exponent (count (str num))
        digits (str->digits-array (str num))]
    (= num (apply + (map #(exp % exponent) digits))))
)