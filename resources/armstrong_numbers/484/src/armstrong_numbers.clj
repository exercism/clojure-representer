(ns armstrong-numbers)

(defn- ** [x n] (reduce * (repeat n x)))

(defn- to-digits [num]
  (map #(BigInteger. (str %)) (seq (str num))))

(defn- square-digits [digits]
  (let [digits-count (count digits)]
    (map #(** % digits-count) digits)))

(defn armstrong? [num]
    (= num (reduce + (square-digits (to-digits num)))))
