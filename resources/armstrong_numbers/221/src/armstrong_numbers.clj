(ns armstrong-numbers)

;; Don't use Math/pow; it has insufficient precision for the final test.
(defn- pow [x y]
  (reduce * (long 1) (repeat y (long x))))

(defn- arm-sum [n digits]
  (->> digits
       (map #(pow % n))
       (reduce + (long 0))))

(defn armstrong? [num]
  (let [n (count (str num))
        digits (->> num str seq (map #(Character/digit % 10)))]
    (= num (arm-sum n digits))))
