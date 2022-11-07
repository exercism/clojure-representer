(ns armstrong-numbers)

(defn digits [num]
  (let [digit (mod num 10)
        residual (if (zero? num) 0 (bigint (/ num 10)))]
    (if (zero? residual) [(int digit)] (conj (digits residual) (int digit)))))

(defn exp [n base]
  (reduce * (repeat n base)))

(defn armstrong? [num]
  (let [digits (digits num)
        powerFn (partial exp (count digits))]
    (->> digits
         (map powerFn)
         (reduce +)
         (== num))))