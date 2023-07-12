(ns armstrong-numbers)

(defn digits
  [n]
  (map #(Character/digit ^char % 10) (str n)))

(defn power
  [exp n]
  (reduce * (repeat exp n)))

(defn sum-of-powers
  [exp xs]
  (reduce #(+ %1 (power exp %2)) 0 xs))

(defn armstrong? [n]
  (let [xs (digits n)]
    (= n (sum-of-powers (count xs) xs))))

