(ns armstrong-numbers)

(defn- digits [n & result]
  (if (zero? n) result
    (recur (quot n 10) (conj result (rem n 10)))))
(defn- raise [all]
  (for [digit all] (apply * (repeat (count all) digit))))
(defn armstrong? [n]
  (->> (digits n)
       (raise)
       (apply +)
       (= n)))