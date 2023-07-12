(ns armstrong-numbers)

(defn digits [num]
  (if (< num 10)
    [num]
    (conj (digits (quot num 10)) (rem num 10))))

(defn armstrong? [num]
  (let [nums (digits num)
        exponent (count nums)
        sum (reduce (fn [acc, val] (+ acc (long (Math/pow val exponent)))) 0 nums)]
    (= sum num)))

