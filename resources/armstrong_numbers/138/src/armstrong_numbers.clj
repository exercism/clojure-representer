(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn num2list [num l]
  (if (= num 0)
    l
    (num2list (quot num 10)  (conj l (rem num 10)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [x (num2list num [])
        n (count x)]
    (= num (reduce + (map #(math/expt % n) x)))))
