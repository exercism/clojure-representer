(ns armstrong-numbers)

(defn digits [x]
  (map #(Character/digit % 10) (str x)))

(defn big-pow [a b]
  (.pow (java.math.BigDecimal. a) b))

(defn consecutive-power-sum [xs]
  (reduce + (map #(big-pow (second %) (count xs)) (map-indexed vector xs))))

(defn armstrong? [num]
  (== (consecutive-power-sum (digits num)) num))
