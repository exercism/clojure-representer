(ns armstrong-numbers
  (:require [clojure.math]))

(defn int-pow [a b]
  (reduce (fn [p _] (*' p a)) 1N (range b)))

(defn order-of-magnitude [n]
  (int (clojure.math/log10 n)))

(defn armstrong? [n]
  (or (zero? n)
  (let [N (bigint n) n-digits (inc (order-of-magnitude n))]
    (loop [z N n N]
      (if (zero? n)
        (zero? z)
        (recur (-' z (int-pow (rem n 10) n-digits)) (quot n 10)))))))